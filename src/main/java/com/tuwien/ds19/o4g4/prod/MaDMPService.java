package com.tuwien.ds19.o4g4.prod;

import com.google.gson.Gson;
import com.joestelmach.natty.Parser;
import com.tuwien.ds19.o4g4.prod.config.FWFTemplateConfig;
import com.tuwien.ds19.o4g4.prod.config.HorizonTemplateConfig;
import com.tuwien.ds19.o4g4.prod.data.AnswersRepository;
import com.tuwien.ds19.o4g4.prod.data.DMPJSON;
import com.tuwien.ds19.o4g4.prod.data.entity.Answer;
import com.tuwien.ds19.o4g4.prod.data.entity.madmp.*;
import com.tuwien.ds19.o4g4.prod.data.entity.Plan;
import com.tuwien.ds19.o4g4.prod.util.DataAccessType;
import com.tuwien.ds19.o4g4.prod.util.Patterns;
import com.tuwien.ds19.o4g4.prod.util.TFAnswer;
import com.tuwien.ds19.o4g4.prod.util.TypeIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

@Service
public class MaDMPService {

    private final AnswersRepository answersRepository;

    private Logger logger = LoggerFactory.getLogger(MaDMPService.class);

    public MaDMPService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    public DMP getDMPFromPlan(Plan p) {

        DMP newDmp = new DMP();
        newDmp.setTitle(p.getTitle());
        newDmp.setDescription(p.getDescription());
        newDmp.setLanguage("en");
        newDmp.setCreated(p.getCreated());
        newDmp.setModified(p.getUpdated());
        newDmp.setDataset(new ArrayList<>());
        newDmp.getDataset().add(new Dataset(new Distribution()));

        setContact(p, newDmp);
        setProject(p, newDmp);

        parseAnswers(p, newDmp);

        return newDmp;
    }

    public String getJSONDMP(DMP dmp) {
        Gson gson = new Gson();
        return gson.toJson(new DMPJSON(dmp));
    }

    private void parseAnswers(Plan p, DMP dmp) {
        List<Answer> answers = answersRepository.findAllByPlanId(p.getId());

        // check if this plan is from Horizon 2020 or FWF template
        int q_id = answers.get(0).getQuestion_id();

        if (q_id >= HorizonTemplateConfig.QUESTION_ID_RANGE_START &&
                q_id <= HorizonTemplateConfig.QUESTION_ID_RANGE_END) { // H2020
            Dataset ds = dmp.getDataset().get(0);
            Distribution dst = ds.getDistribution().get(0);
            for (Answer a : answers) {
                parseH2020Answer(a, dmp, ds, dst);
            }
        } else if (q_id >= FWFTemplateConfig.QUESTION_ID_RANGE_START &&
                q_id <= FWFTemplateConfig.QUESTION_ID_RANGE_END) {
            Dataset ds = dmp.getDataset().get(0);
            Distribution dst = ds.getDistribution().get(0);
            for (Answer a : answers) {
                parseFWFAnswer(a, dmp, ds, dst);
            }
        }
    }

    private void parseH2020Answer(Answer a, DMP dmp, Dataset ds, Distribution dist) {
        String text = a.getText();

        if (text.isEmpty()) {
            return;
        }

        switch (HorizonTemplateConfig.QUESTIONS_MAP.get(a.getQuestion_id())) {
            case 1:
                dmp.getProject().get(0).setDescription(text);
                break;
            case 2:
                for (Dataset.DatasetTypeEnum dt : Dataset.DatasetTypeEnum.values()) {
                    if (text.toLowerCase().contains(dt.name())) {
                        ds.setType(dt.name());
                    }
                }
                for (Distribution.DatasetFormat df : Distribution.DatasetFormat.values()) {
                    if (text.toLowerCase().contains(df.name())) {
                        dist.setFormat(df.name());
                    }
                }
                break;
            case 3:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("reuse_existing_data")));
                break;
            case 4:
                Matcher m = Patterns.getURL().matcher(text);
                if (m.matches()) {
                    dist.setAccessURL(m.group(1));
                    dist.setDownloadURL(m.group(1));
                }
                break;
            case 5:
                dist.setByteSize(getByteSize(text));
                break;
            case 6:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("useful_to")));
                break;
            case 7:
                Matcher matcher = Patterns.getDOI().matcher(text);
                Dataset_Id dataset_id = new Dataset_Id(matcher.find() ? matcher.group(1) : text);
                dataset_id.setdataset_id_type(TypeIdentifier.checkType(text));
                ds.setDataset_id(dataset_id);
                break;
            case 8:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("naming_convention")));
                break;
            case 9:
                if (text.contains(",")) {

                    ds.setKeyword(Arrays.asList(text.trim().split("\\s*,\\s*")));
                } else if (text.contains(";")) {
                    ds.setKeyword(Arrays.asList(text.trim().split("\\s*;\\s*")));
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(text);
                    ds.setKeyword(list);
                }
                break;
            case 10:
                if (text.contains(TFAnswer.yes.name())) {
                    dist.getHost().setSupports_versioning(TFAnswer.yes.name());
                } else if (text.contains(TFAnswer.no.name())) {
                    dist.getHost().setSupports_versioning(TFAnswer.no.name());
                } else {
                    dist.getHost().setSupports_versioning(TFAnswer.unknown.name());
                }
                break;
            case 11:
            case 24:
            case 25:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("metadata_standard")));
                break;
            case 12:
                if (text.toLowerCase().contains(DataAccessType.open.name())) {
                    dist.setData_access(DataAccessType.open.name());
                } else if (text.toLowerCase().contains(DataAccessType.closed.name())) {
                    dist.setData_access(DataAccessType.closed.name());
                } else if (text.toLowerCase().contains(DataAccessType.shared.name())) {
                    dist.setData_access(DataAccessType.shared.name());
                }
                if (text.toLowerCase().contains("personal")) {
                    ds.setPersonalData(TFAnswer.yes.name());
                } else {
                    ds.setPersonalData(TFAnswer.unknown.name());
                    if (text.toLowerCase().contains("sensitive")) {
                        ds.setSensitiveData(TFAnswer.yes.name());
                    } else {
                        ds.setSensitiveData(TFAnswer.unknown.name());
                    }
                }
                break;
            case 13:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("multi_beneficiary_project")));
                break;
            case 14:
                dist.getHost().setStorage_type(text);
                break;
            case 15:
            case 16:
                ds.getTechnicalResource().add(new TechnicalResource(text, new TextType_Id("software_tools")));
                break;
            case 17:
                ds.getTechnicalResource().add(new TechnicalResource("relevant software included: " + text,
                        new TextType_Id("software_tools")));
                break;
            case 18:
                dist.getHost().setTitle(text);
                break;
            case 19:
                dist.getHost().setDescription("Appropriate arrangements with the identified repository explored: " + text);
                break;
            case 20:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("access_provided")));
                break;
            case 21:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("data_access_committee_needed")));
                break;
            case 22:
            case 23:
                ds.getSecurityAndPrivacy().add(new SecurityAndPrivacy("AccessAuthorization", text));
                break;
            case 26:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("standard_vocabulary")));
                break;
            case 27:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("ontology_mappings")));
                break;
            case 28:
                Matcher mURI = Patterns.getURI().matcher(text);
                if (mURI.matches()) {
                    if (dist.getLicense().isEmpty()) {
                        dist.getLicense().add(new License());
                    }
                    dist.getLicense().get(0).setLicense_ref(mURI.group(1));
                }
                break;
            case 29:
                if (dist.getLicense().isEmpty()) {
                    dist.getLicense().add(new License());
                }
                List<Date> dates = new Parser().parse(text).get(0).getDates();
                if (!dates.isEmpty()) {
                    dist.getLicense().get(0).setStartDate(dates.get(0));
                }
                break;
            case 30:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("data_reusable")));
                break;
            case 31:
                List<Date> dates2 = new Parser().parse(text).get(0).getDates();
                if (!dates2.isEmpty()) {
                    dist.setAvailableTill(dates2.get(0));
                }
                break;
            case 32:
                ds.setDataQualityAssurance(text);
                break;
            case 33:
                Cost cost = new Cost("Making data FAIR");
                if (text.contains("€") || text.toLowerCase().contains("eur")) {
                    cost.setCostUnit("EUR");
                } else if (text.contains("$") || text.toLowerCase().contains("usd")) {
                    cost.setCostUnit("USD");
                }
                text = text.replaceAll("\\D+","");
                cost.setCostValue(Double.parseDouble(text));
                List<Cost> costs = new ArrayList<>();
                costs.add(cost);
                dmp.setCost(costs);
                break;
            case 34:
                Funding funding = new Funding();
                funding.setFunderID(text);
                break;
            case 35:
                DMStaff dmStaff = new DMStaff();
                Matcher mURLo = Patterns.getURL().matcher(text);
                if (mURLo.find()) { // DMStaff orcid url?
                    String id = mURLo.group(1);
                    logger.info("url matches: " + id);
                    dmStaff.setUserID(new User_Id(id, "HTTP-ORCID"));
                    text = text.replace(id, "");
                } else {
                    Matcher mORCID = Patterns.getORCID().matcher(text);
                    if (mORCID.find()) { // DMStaff orcid only?
                        String id = mORCID.group(1);
                        logger.info("orcid matches: " + id);
                        dmStaff.setUserID(new User_Id(id));
                        text = text.replace(id, "");
                    }
                }
                Matcher mMail = Patterns.getMail().matcher(text);
                if (mMail.find()) { // DMStaff mail?
                    String mail = mMail.group(1);
                    logger.info("mail matches: " + mail);
                    dmStaff.setMbox(mail);
                    text = text.replace(mail, "");
                }
                text = text.trim();
                dmStaff.setName(text);
                dmStaff.setContributerType("Data officer");
                List<DMStaff> dmStaffs = new ArrayList<>();
                dmStaffs.add(dmStaff);
                dmp.setDmStaff(dmStaffs);
                break;
            case 36:
                ds.setPreservationStatement(text);
                break;
            case 37:
                ds.getSecurityAndPrivacy().add(new SecurityAndPrivacy("DataSecurity", text));
                break;
            case 38:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("data_stored_securely")));
                break;
            case 39:
                Matcher mURL = Patterns.getURL().matcher(text);
                if (mURL.matches()) {
                    String url = mURL.group(1);
                    dmp.setEthicalIssuesReport(url);
                    text = text.replace(url, "");
                }
                if (text.toLowerCase().contains(TFAnswer.yes.name())) {
                    dmp.setEthicalIssuesExist(TFAnswer.yes.name());
                    text = text.toLowerCase().replace(TFAnswer.yes.name(), "");
                } else if (text.toLowerCase().contains(TFAnswer.no.name())) {
                    dmp.setEthicalIssuesExist(TFAnswer.no.name());
                    text = text.toLowerCase().replace(TFAnswer.no.name(), "");
                } else {
                    dmp.setEthicalIssuesExist(TFAnswer.unknown.name());
                }
                dmp.setEthicalIssuesDescription(text);
                break;
            case 40:
                if (dmp.getEthicalIssuesReport() == null || dmp.getEthicalIssuesReport().isEmpty()) {
                    Matcher mURLrep = Patterns.getURL().matcher(text);
                    if (mURLrep.matches()) {
                        String url = mURLrep.group(1);
                        dmp.setEthicalIssuesReport(url);
                    }
                }
                break;
            case 41:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("personal_data_sharing_consent")));
                break;
            case 42:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("data_management_procedures")));
                break;
        }
    }

    private void parseFWFAnswer(Answer a, DMP dmp, Dataset ds, Distribution dist){
        String text = a.getText();

        if(text.isEmpty()){
            return;
        }

        switch (FWFTemplateConfig.QUESTIONS_MAP.get(a.getQuestion_id())) {
            case 43:
                DMStaff dmStaff = new DMStaff();
                Matcher mURLo = Patterns.getURL().matcher(text);
                if (mURLo.find()) { // DMStaff orcid url?
                    String id = mURLo.group(1);
                    logger.info("url matches: " + id);
                    dmStaff.setUserID(new User_Id(id, "HTTP-ORCID"));
                    text = text.replace(id, "");
                } else {
                    Matcher mORCID = Patterns.getORCID().matcher(text);
                    if (mORCID.find()) { // DMStaff orcid only?
                        String id = mORCID.group(1);
                        logger.info("orcid matches: " + id);
                        dmStaff.setUserID(new User_Id(id));
                        text = text.replace(id, "");
                    }
                }
                Matcher mMail = Patterns.getMail().matcher(text);
                if (mMail.find()) { // DMStaff mail?
                    String mail = mMail.group(1);
                    logger.info("mail matches: " + mail);
                    dmStaff.setMbox(mail);
                    text = text.replace(mail, "");
                }
                text = text.trim();
                dmStaff.setName(text);
                dmStaff.setContributerType("Data officer");
                List<DMStaff> dmStaffs = new ArrayList<>();
                dmStaffs.add(dmStaff);
                dmp.setDmStaff(dmStaffs);
                break;
            case 44:
                for (Dataset.DatasetTypeEnum dt : Dataset.DatasetTypeEnum.values()) {
                    if (text.toLowerCase().contains(dt.name())) {
                        ds.setType(dt.name());
                    }
                }
                for (Distribution.DatasetFormat df : Distribution.DatasetFormat.values()) {
                    if (text.toLowerCase().contains(df.name())) {
                        dist.setFormat(df.name());
                    }
                }
                dist.setByteSize(getByteSize(text));
                break;
            case 45:
                ds.setDescription("Methods for data generation: " + text);
                break;
            case 46:
                ds.setDescription("Datastructure and version-handling: " + text);
                break;
            case 47:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("target_audience")));
                break;
            case 48:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("metadata_standard")));
                break;
            case 49:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("make_data_FAIR")));
                break;
            case 50:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("machine_readable")));
                break;
            case 51:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("information_documentation")));
                break;
            case 52:
                ds.setDataQualityAssurance(text);
                break;
            case 53:
                ds.setDataQualityAssurance(text);
                break;
            case 54:
                List<Date> dates = new Parser().parse(text).get(0).getDates();
                if (dist.getLicense().isEmpty()) {
                    dist.getLicense().add(new License());
                }
                dist.getLicense().get(0).setStartDate(dates.get(0));

                if (text.toLowerCase().contains(DataAccessType.open.name())) {
                    dist.setData_access(DataAccessType.open.name());
                } else if (text.toLowerCase().contains(DataAccessType.closed.name())) {
                    dist.setData_access(DataAccessType.closed.name());
                } else if (text.toLowerCase().contains(DataAccessType.shared.name())) {
                    dist.setData_access(DataAccessType.shared.name());
                }
                break;
            case 55:
                dist.getHost().setTitle(text);
                break;
            case 56:
                Matcher matcher = Patterns.getDOI().matcher(text);
                Dataset_Id dataset_id = new Dataset_Id(matcher.find() ? matcher.group(1) : text);
                dataset_id.setdataset_id_type(TypeIdentifier.checkType(text));
                ds.setDataset_id(dataset_id);
                break;
            case 57:
                ds.setPreservationStatement(text);
                break;
            case 58:
                String[] s = text.split(";");
                if (text.toLowerCase().contains(dist.getHost().getTitle().toLowerCase())) {
                    dist.getHost().setStorage_type(s[0]);
                    dist.setDescription("This distribution stores data during the research.");
                } else {
                    Distribution distribution = new Distribution();
                    distribution.setDescription("This distribution stores data during the research.");
                    distribution.getHost().setTitle(s[1]);
                    distribution.getHost().setBackup_type(s[0]);
                    ds.getDistribution().add(distribution);
                }
                break;
            case 59:
                boolean distAlreadyExists = false;
                for(Distribution d : ds.getDistribution()) {
                    if (text.toLowerCase().contains(d.getHost().getTitle().toLowerCase())) {
                        d.setDescription("This distribution stores data after the project ends.");
                        distAlreadyExists = true;
                    }
                }
                if (!distAlreadyExists) {
                    ds.getDistribution().get(ds.getDistribution().size() - 1).setAvailableTill(dmp.getProject().get(0).getProjectEnd());
                    Distribution distribution = new Distribution();
                    distribution.setDescription("This distribution stores data after the project ends.");
                    distribution.getHost().setTitle(text);
                    ds.getDistribution().add(distribution);
                }
                break;
            case 60:
                List<Date> dates2 = new Parser().parse(text).get(0).getDates();
                if (!dates2.isEmpty()) {
                    ds.getDistribution().get(ds.getDistribution().size() - 1).setAvailableTill(dates2.get(0));
                }
                break;
            case 61:
                Cost cost = new Cost("Cost for storing data.");
                if (text.contains("€") || text.toLowerCase().contains("eur")) {
                    cost.setCostUnit("EUR");
                } else if (text.contains("$") || text.toLowerCase().contains("usd")) {
                    cost.setCostUnit("USD");
                }
                text = text.replaceAll("\\D+","");
                cost.setCostValue(Double.parseDouble(text));

                List<Cost> costs = new ArrayList<>();
                costs.add(cost);
                dmp.setCost(costs);
                break;
            case 62:
                ds.setDescription(text);
                break;
            case 63:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("technical_barriers")));
                break;
            case 64:
                if (text.toLowerCase().contains("personal")) {
                    ds.setPersonalData(TFAnswer.yes.name());
                } else {
                    ds.setPersonalData(TFAnswer.unknown.name());
                    if (text.toLowerCase().contains("sensitive")) {
                        ds.setSensitiveData(TFAnswer.yes.name());
                    } else {
                        ds.setSensitiveData(TFAnswer.unknown.name());
                    }
                }
                break;
            case 65:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("owner_statement")));
                break;
            case 66:
                Matcher mURI = Patterns.getURI().matcher(text);
                for (Distribution d : ds.getDistribution()) {
                    if (d.getDescription().contains("after the project ends") && mURI.matches()) {
                        if (d.getLicense().isEmpty()) {
                            d.getLicense().add(new License());
                        }
                        d.getLicense().get(0).setLicense_ref(mURI.group(1));
                    }
                }
                break;
            case 67:
                ds.getMetadata().add(new Metadata(text, new TextType_Id("data_reuse_restrictions")));
                break;
            case 68:
                Matcher mURL = Patterns.getURL().matcher(text);
                if (mURL.matches()) {
                    String url = mURL.group(1);
                    dmp.setEthicalIssuesReport(url);
                    text = text.replace(url, "");
                }
                if (text.toLowerCase().contains(TFAnswer.yes.name())) {
                    dmp.setEthicalIssuesExist(TFAnswer.yes.name());
                    text = text.toLowerCase().replace(TFAnswer.yes.name(), "");
                } else if (text.toLowerCase().contains(TFAnswer.no.name())) {
                    dmp.setEthicalIssuesExist(TFAnswer.no.name());
                    text = text.toLowerCase().replace(TFAnswer.no.name(), "");
                } else {
                    dmp.setEthicalIssuesExist(TFAnswer.unknown.name());
                }
                dmp.setEthicalIssuesDescription(text);
                break;
            case 69:
                ds.getSecurityAndPrivacy().add(new SecurityAndPrivacy("SensitiveDataStatement", text));
                break;
        }
    }

    private int getByteSize(String text){
        int size = Integer.parseInt(text.replaceAll("[^0-9]", ""));
        if (text.toLowerCase().contains("kb")) {
            size = size * 1024;
        } else if (text.toLowerCase().contains("mb")) {
            size = size * 1024 * 1024;
        } else if (text.toLowerCase().contains("gb")) {
            size = size * 1024 * 1024 * 1024;
        }
        return size;
    }

    private void setContact(Plan p, DMP dmp) {
        if (!p.getPrincipal_investigator().isEmpty()) {
            Contact_Id cid = null;
            if (!p.getPrincipal_investigator_identifier().isEmpty()) {
                cid = new Contact_Id(p.getPrincipal_investigator_identifier());
                cid.setContact_id_type(TypeIdentifier.checkType(cid.getContact_id()));
            }
            dmp.setContact(new Contact(
                    p.getPrincipal_investigator(),
                    p.getPrincipal_investigator_email(),
                    p.getPrincipal_investigator_phone(),
                    cid));
        }
    }

    private void setProject(Plan p, DMP dmp) {
        if (!p.getTitle().isEmpty()) {
            Project project = new Project(p.getTitle(), p.getDescription());
            project.addFunding(getFunding(p));
            List<Project> projectList = new ArrayList<>();
            projectList.add(project);
            dmp.setProject(projectList);
        }
    }

    private Funding getFunding(Plan p) {
        Funding funding = new Funding();
        if (!p.getFunder_name().isEmpty()) {
            funding.setFunderID(p.getFunder_name());
        }
        if (!p.getGrant_number().isEmpty()) {
            funding.setGrantID(p.getGrant_number());
        }
        return funding;
    }
}
