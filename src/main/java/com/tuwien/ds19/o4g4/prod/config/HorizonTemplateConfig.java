package com.tuwien.ds19.o4g4.prod.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HorizonTemplateConfig {

    private static final Map<Integer, String> QUESTIONS;
    public static final Map<Integer, Integer> QUESTIONS_MAP;
    public static final int QUESTION_ID_RANGE_START = 1;
    public static final int QUESTION_ID_RANGE_END = 42;

    static {

        // This is used as mapping between the Database Question ID and the internally used ID
        // key: DB QId, value: Internal Id
        Map<Integer, Integer> qMapping = new HashMap<>();
        qMapping.put(1,1);
        qMapping.put(2,2);
        qMapping.put(3,3);
        qMapping.put(4,4);
        qMapping.put(5,5);
        qMapping.put(6,6);
        qMapping.put(7,7);
        qMapping.put(8,8);
        qMapping.put(9,9);
        qMapping.put(10,10);
        qMapping.put(11,11);
        qMapping.put(12,12);
        qMapping.put(13,13);
        qMapping.put(14,14);
        qMapping.put(15,15);
        qMapping.put(16,16);
        qMapping.put(17,17);
        qMapping.put(18,18);
        qMapping.put(19,19);
        qMapping.put(20,20);
        qMapping.put(21,21);
        qMapping.put(22,22);
        qMapping.put(23,23);
        qMapping.put(24,24);
        qMapping.put(25,25);
        qMapping.put(26,26);
        qMapping.put(27,27);
        qMapping.put(28,28);
        qMapping.put(29,29);
        qMapping.put(30,30);
        qMapping.put(31,31);
        qMapping.put(32,32);
        qMapping.put(33,33);
        qMapping.put(34,34);
        qMapping.put(35,35);
        qMapping.put(36,36);
        qMapping.put(37,37);
        qMapping.put(38,38);
        qMapping.put(39,39);
        qMapping.put(40,40);
        qMapping.put(41,41);
        qMapping.put(42,42);
        QUESTIONS_MAP = Collections.unmodifiableMap(qMapping);

        // This is the currently used question catalog
        // where the key matches the value in the QUESTIONS_MAP
        // which is only used internally
        Map<Integer, String> qM = new HashMap<>();
        qM.put(1, "What is the purpose of the data collection/generation and its relation to the objectives of the project?");
        qM.put(2, "What types and formats of data will the project generate/collect?");
        qM.put(3, "Will you re-use any existing data and how?");
        qM.put(4, "What is the origin of the data?");
        qM.put(5, "What is the expected size of the data?");
        qM.put(6, "To whom might it be useful (\"data utility\")?");
        qM.put(7, "Are the data produced and/or used in the project discoverable with metadata, identifiable and locatable by means of a standard identification mechanism (e.g. persistent and unique identifiers such as Digital Object Identifiers)?");
        qM.put(8, "What naming conventions do you follow?");
        qM.put(9, "Will search keywords be provided that optimize possibilities for re-use?");
        qM.put(10, "Do you provide clear version numbers?");
        qM.put(11, "What metadata will be created? In case metadata standards do not exist in your discipline, please outline what type of metadata will be created and how.");
        qM.put(12, "Which data produced and/or used in the project will be made openly available as the default? If certain datasets cannot be shared (or need to be shared under restrictions), explain why, clearly separating legal and contractual reasons from voluntary rest...");
        qM.put(13, "Note that in multi-beneficiary projects it is also possible for specific beneficiaries to keep their data closed if relevant provisions are made in the consortium agreement and are in line with the reasons for opting out.");
        qM.put(14, "How will the data be made accessible (e.g. by deposition in a repository)?");
        qM.put(15, "What methods or software tools are needed to access the data?");
        qM.put(16, "Is documentation about the software needed to access the data included?");
        qM.put(17, "Is it possible to include the relevant software (e.g. in open source code)?");
        qM.put(18, "Where will the data and associated metadata, documentation and code be deposited? Preference should be given to certified repositories which support open access where possible.");
        qM.put(19, "Have you explored appropriate arrangements with the identified repository?");
        qM.put(20, "If there are restrictions on use, how will access be provided?");
        qM.put(21, "Is there a need for a data access committee?");
        qM.put(22, "Are there well described conditions for access (i.e. a machine readable license)?");
        qM.put(23, "How will the identity of the person accessing the data be ascertained?");
        qM.put(24, "Are the data produced in the project interoperable, that is allowing data exchange and re-use between researchers, institutions, organisations, countries, etc. (i.e. adhering to standards for formats, as much as possible compliant with available (open) s...");
        qM.put(25, "What data and metadata vocabularies, standards or methodologies will you follow to make your data interoperable?");
        qM.put(26, "Will you be using standard vocabularies for all data types present in your data set, to allow inter-disciplinary interoperability?");
        qM.put(27, "In case it is unavoidable that you use uncommon or generate project specific ontologies or vocabularies, will you provide mappings to more commonly used ontologies?");
        qM.put(28, "How will the data be licensed to permit the widest re-use possible?");
        qM.put(29, "When will the data be made available for re-use? If an embargo is sought to give time to publish or seek patents, specify why and how long this will apply, bearing in mind that research data should be made available as soon as possible.");
        qM.put(30, "Are the data produced and/or used in the project useable by third parties, in particular after the end of the project? If the re-use of some data is restricted, explain why.");
        qM.put(31, "How long is it intended that the data remains re-usable?");
        qM.put(32, "Are data quality assurance processes described?");
        qM.put(33, "What are the costs for making data FAIR in your project?");
        qM.put(34, "How will these be covered? Note that costs related to open access to research data are eligible as part of the Horizon 2020 grant (if compliant with the Grant Agreement conditions).");
        qM.put(35, "Who will be responsible for data management in your project?");
        qM.put(36, "Are the resources for long term preservation discussed (costs and potential value, who decides and how what data will be kept and for how long)?");
        qM.put(37, "What provisions are in place for data security (including data recovery as well as secure storage and transfer of sensitive data)?");
        qM.put(38, "Is the data safely stored in certified repositories for long term preservation and curation?");
        qM.put(39, "Are there any ethical or legal issues that can have an impact on data sharing? These can also be discussed in the context of the ethics review. If relevant, include references to ethics deliverables and ethics chapter in the Description of the Action (Do...");
        qM.put(40, "Projects participating to the ORDP might present information relevant to the ethical aspects (data protection) in the DMP. In such a case, the ethics chapter of the DoA may simply refer to the DMP for more information on the details of the ethics aspects...");
        qM.put(41, "Is informed consent for data sharing and long term preservation included in questionnaires dealing with personal data?");
        qM.put(42, "Do you make use of other national/funder/sectorial/departmental procedures for data management? If yes, which ones?");

        QUESTIONS = Collections.unmodifiableMap(qM);
    }

}
