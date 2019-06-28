package com.tuwien.ds19.o4g4.prod;

import com.google.gson.Gson;
import com.tuwien.ds19.o4g4.prod.config.HorizonTemplateConfig;
import com.tuwien.ds19.o4g4.prod.data.AnswersRepository;
import com.tuwien.ds19.o4g4.prod.data.DMPJSON;
import com.tuwien.ds19.o4g4.prod.data.entity.Answer;
import com.tuwien.ds19.o4g4.prod.data.entity.madmp.*;
import com.tuwien.ds19.o4g4.prod.data.entity.Plan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaDMPService {

    private final AnswersRepository answersRepository;

    public MaDMPService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    public DMP getDMPFromPlan(Plan p){

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

    public String getJSONDMP(DMP dmp){
        Gson gson = new Gson();
        return gson.toJson(new DMPJSON(dmp));
    }

    private void parseAnswers(Plan p, DMP dmp){
        List<Answer> answers = answersRepository.findAllByPlan_id(p.getId());

        // check if this plan is from Horizon 2020 or FWF template
        int q_id = answers.get(0).getQuestion_id();

        if(q_id >= HorizonTemplateConfig.QUESTION_ID_RANGE_START &&
                q_id <= HorizonTemplateConfig.QUESTION_ID_RANGE_END){ // H2020


        } else if(false){ // TODO FWF

        }
    }

    private void parseH2020Answer(Answer a, DMP dmp){
        String text = a.getText();
        Dataset ds = dmp.getDataset().get(0);
        Distribution dist = ds.getDistribution().get(0);
        switch(HorizonTemplateConfig.QUESTIONS_MAP.get(a.getQuestion_id())){
            case 1:
            case 4:
            case 6:
                ds.setDescription(text);
                break;
            case 2:
                for(Dataset.DatasetTypeEnum dt : Dataset.DatasetTypeEnum.values()){
                    if(text.toLowerCase().contains(dt.name())){
                        ds.setType(dt.name());
                    }
                }
                for(Distribution.DatasetFormat df : Distribution.DatasetFormat.values()){
                    if(text.toLowerCase().contains(df.name())){
                        dist.setFormat(df.name());
                    }
                }
                break;
            case 3:
                dist.setAccessURL(text);
                dist.setDownloadURL(text);
                break;
            case 5:
                int size = Integer.parseInt(text.replaceAll("[^0-9]", ""));
                if(text.toLowerCase().contains("kb")){
                    size = size * 1024;
                } else if (text.toLowerCase().contains("mb")){
                    size = size * 1024 * 1024;
                } else if (text.toLowerCase().contains("gb")){
                    size = size * 1024 * 1024 * 1024;
                }
                dist.setByteSize(size);
                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
        }
    }

    private void setContact(Plan p, DMP dmp){
        if(!p.getPrincipal_investigator().isEmpty()){
            Contact_Id cid = null;
            if(!p.getPrincipal_investigator_identifier().isEmpty()){
                cid = new Contact_Id(p.getPrincipal_investigator_identifier());

                if(cid.getContact_id().toLowerCase().contains("orcid")){
                    cid.setContact_id_type("HTTP-ORCID");
                }
            }
            dmp.setContact(new Contact(
                    p.getPrincipal_investigator(),
                    p.getPrincipal_investigator_email(),
                    p.getPrincipal_investigator_phone(),
                    cid));
        }
    }

    private void setProject(Plan p, DMP dmp){
        if(!p.getTitle().isEmpty()){
            Project project = new Project(p.getTitle(), p.getDescription());
            project.setFunding(getFunding(p));
            List<Project> projectList = new ArrayList<>();
            projectList.add(project);
            dmp.setProject(projectList);
        }
    }

    private Funding getFunding(Plan p){
        Funding funding = new Funding();
        if(!p.getFunder_name().isEmpty()){
            funding.setFunderID(p.getFunder_name());
        }
        if(!p.getGrant_number().isEmpty()){
            funding.setGrantID(p.getGrant_number());
        }
        return funding;
    }
}
