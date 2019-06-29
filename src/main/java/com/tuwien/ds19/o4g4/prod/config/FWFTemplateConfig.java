package com.tuwien.ds19.o4g4.prod.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FWFTemplateConfig {

    private static final Map<Integer, String> QUESTIONS;
    public static final Map<Integer, Integer> QUESTIONS_MAP;
    public static final int QUESTION_ID_RANGE_START = 43;
    public static final int QUESTION_ID_RANGE_END = 69;

    static {

        // This is used as mapping between the Database Question ID and the internally used ID
        // key: DB QId, value: Internal Id
        Map<Integer, Integer> qMapping = new HashMap<>();
        qMapping.put(43,43);
        qMapping.put(44,44);
        qMapping.put(45,45);
        qMapping.put(46,46);
        qMapping.put(47,47);
        qMapping.put(48,48);
        qMapping.put(49,49);
        qMapping.put(50,50);
        qMapping.put(51,51);
        qMapping.put(52,52);
        qMapping.put(53,53);
        qMapping.put(54,54);
        qMapping.put(55,55);
        qMapping.put(56,56);
        qMapping.put(57,57);
        qMapping.put(58,58);
        qMapping.put(59,59);
        qMapping.put(60,60);
        qMapping.put(61,61);
        qMapping.put(62,62);
        qMapping.put(63,63);
        qMapping.put(64,64);
        qMapping.put(65,65);
        qMapping.put(66,66);
        qMapping.put(67,67);
        qMapping.put(68,68);
        qMapping.put(69,69);
        QUESTIONS_MAP = Collections.unmodifiableMap(qMapping);

        // This is the currently used question catalog
        // where the key matches the value in the QUESTIONS_MAP
        // which is only used internally
        Map<Integer, String> qM = new HashMap<>();
        qM.put(43, "Who is responsible for the data management and the DMP of the project (name/email address)?");
        qM.put(44, "What kinds of data/source code will be generated or reused (type, format, volume)?");
        qM.put(45, "How will the research data be generated and which methods will be used?");
        qM.put(46, "How will you structure the data and handle versioning?");
        qM.put(47, "Who is the target audience?");
        qM.put(48, "What metadata standards (if any) will be in use and why? (see Digital Curation Centre)");
        qM.put(49, "What information is needed for the data to be findable, accessible, interoperable and re-usable (FAIR) in the future?");
        qM.put(50, "Is the data machine-readable?");
        qM.put(51, "How are you planning to document this information?");
        qM.put(52, "What quality assurance processes will you adopt?");
        qM.put(53, "How will the consistency and quality of data collection be controlled and documented? (This may include processes such as repeat samples or measurements, standardised data capture, peer review of data or representation with controlled vocabularies.");
        qM.put(54, "How and when will the data be shared and made accessible?");
        qM.put(55, "What repository will you be using?");
        qM.put(56, "What persistent identifier will be used?");
        qM.put(57, "What data are to be preserved for the long-term, and what data will not be stored?");
        qM.put(58, "How and where will the data be stored and backed up during the research?");
        qM.put(59, "How and where will the data be stored after the project ends?");
        qM.put(60, "For how long will the data be stored?");
        qM.put(61, "Are there any costs that need to be covered for storage?");
        qM.put(62, "At what point during or after the project will the data be stored?");
        qM.put(63, "Are there any technical barriers to making the research data fully or partially accessible?");
        qM.put(64, "Are there any legal barriers to making the research data fully or partially accessible?");
        qM.put(65, "Who owns the data?");
        qM.put(66, "What licence for reuse are you planning to attach to the data?");
        qM.put(67, "Are there any restrictions on the re-use of the data? If so, why?");
        qM.put(68, "Are there any ethical barriers to making the research data fully or partially accessible?");
        qM.put(69, "If applicable, how are you planning to deal with sensitive data during and after the project?");

        QUESTIONS = Collections.unmodifiableMap(qM);
    }

}
