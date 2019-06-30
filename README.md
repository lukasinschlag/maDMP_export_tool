# maDMP_export_tool

In this project the RDA DMP Common Standard was evaluated by mapping it to funder templates and by implementing a tool
that exports information from existing DMP tools into maDMP format.

# Mapping of questions to maDMP fields
## Horizon 2020

### Data summary ###
- What is the purpose of the data collection/generation and its relation to the objectives of the project?  
`Project:description`

- What types and formats of data will the project generate/collect?  
`Dataset:type`  
`Dataset:format`

- Will you re-use any existing data and how?  
`Metadata:reuse_existing_data`

- What is the origin of the data?  
`Distribution:accessURL`  
`Distribution:downloadURL`

- What is the expected size of the data?  
`Distribution:byteSize`

- To whom might it be useful ('data utility')?  
`Metadata:useful_to` 

### FAIR ###
#### Making data findable, including provisions for metadata ####
- Are the data produced and/or used in the project discoverable with metadata, identifiable and locatable by means of a standard identification mechanism (e.g. persistent and unique identifiers such as Digital Object Identifiers)?  
`Dataset:dataset_id`

- What naming conventions do you follow?
`Metadata:naming_convention`

- Will search keywords be provided that optimize possibilities for re-use?   
`Dataset:keyword`

- Do you provide clear version numbers?  
`Host:supportsVersioning`

- What metadata will be created? In case metadata standards do not exist in your discipline, please outline what type of metadata will be created and how.  
`Metadata:metadata_standard`
 
#### Making data openly accessible ####
- Which data produced and/or used in the project will be made openly available as the default? If certain datasets cannot be shared (or need to be shared under restrictions), explain why, clearly separating legal and contractual reasons from voluntary restrictions.  
`Distribution:dataAccess`  
`Dataset:sensitiveData`  
`Dataset:personalData`

- Note that in multi-beneficiary projects it is also possible for specific beneficiaries to keep their data closed if
relevant provisions are made in the consortium agreement and are in line with the reasons for opting out.  
`MetaData:multi_beneficiary_project`

- How will the data be made accessible (e.g. by deposition in a repository)?  
`Host:storage_type`

- What methods or software tools are needed to access the data?  
`TechnicalResource:software_tools`

- Is documentation about the software needed to access the data included?  
`TechnicalResource:software_tools`

- Is it possible to include the relevant software (e.g. in open source code)?  
`TechnicalResource:software_tools`

- Where will the data and associated metadata, documentation and code be deposited? Preference should be
given to certified repositories which support open access where possible.  
`Host:title`

- Have you explored appropriate arrangements with the identified repository?  
`Host:description`

- If there are restrictions on use, how will access be provided?  
`MetaData:access_provided`

- Is there a need for a data access committee?  
`MetaData:data_access_committee_needed`

- Are there well described conditions for access (i.e. a machine readable license)?  
`SecurityAndPrivacy:AccessAuthorization`

- How will the identity of the person accessing the data be ascertained?  
`SecurityAndPrivacy:AccessAuthorization`

#### Making data interoperable ####
- Are the data produced in the project interoperable, that is allowing data exchange and re-use between
researchers, institutions, organisations, countries, etc. (i.e. adhering to standards for formats, as much as
possible compliant with available (open) software applications, and in particular facilitating re-combinations with different datasets from different origins)?  
`Metadata:metadata_standard`

- What data and metadata vocabularies, standards or methodologies will you follow to make your data
interoperable?  
`Metadata:metadata_standard`

- Will you be using standard vocabularies for all data types present in your data set, to allow inter-disciplinary
interoperability?  
`Metadata:standard_vocabulary`

- In case it is unavoidable that you use uncommon or generate project specific ontologies or vocabularies, will you provide mappings to more commonly used ontologies?  
`Metadata:ontology_mappings`

#### Increase data re-use (through clarifying licenses) ####
- How will the data be licensed to permit the widest re-use possible?  
`License:licence_ref`

- When will the data be made available for re-use? If an embargo is sought to give time to publish or seek patents, specify why and how long this will apply, bearing in mind that research data should be made available as soon as possible.  
`Licence:startDate`

- Are the data produced and/or used in the project useable by third parties, in particular after the end of the
project? If the re-use of some data is restricted, explain why.   
`Metadata:data_reusable`

- How long is it intended that the data remains re-usable?  
`Distribution:availableTill`

- Are data quality assurance processes described?  
`Dataset:dataQualityAssurance`

### Allocation of resources ###
-  What are the costs for making data FAIR in your project?  
`Cost:costValue`  
`Cost:costUnit`

- How will these be covered? Note that costs related to open access to research data are eligible as part of the Horizon 2020 grant (if compliant with the Grant Agreement conditions).  
`Funding:funderID` 

- Who will be responsible for data management in your project?  
`DMStaff:name`  
`DMStaff:mbox`  
`DMStaff:userID`

- Are the resources for long term preservation discussed (costs and potential value, who decides and how what
data will be kept and for how long)?  
`Dataset:preservationStatement`

### Data security ###
- What provisions are in place for data security (including data recovery as well as secure storage and transfer of
sensitive data)?  
`SecurityAndPrivacy:DataSecurity`

- Is the data safely stored in certified repositories for long term preservation and curation?  
`Metadata:data_stored_securely`

### Ethical aspects ###
- Are there any ethical or legal issues that can have an impact on data sharing? These can also be discussed in
the context of the ethics review. If relevant, include references to ethics deliverables and ethics chapter in the
Description of the Action (DoA).  
`DMP:ethicalIssuesExist`  
`DMP:ethicalIssuesReport`  
`DMP:ethicalIssuesDescription`

- Projects participating to the ORDP might present information relevant to the ethical aspects (data protection) in the DMP. In such a case, the ethics chapter of the DoA may simply refer to the DMP for more information on the details of the ethics aspects related to data.   
`DMP:ethicalIssuesReport` 

- Is informed consent for data sharing and long term preservation included in questionnaires dealing with personal data?  
`Metadata:personal_data_sharing_consent`

### Other ###
- Do you make use of other national/funder/sectorial/departmental procedures for data management? If yes, which ones?  
`Metadata:data_management_procedures`



## FWF  
**Data Officer**

- Who is responsible for the data management and the DMP of the project (name/email address)?  
`DMPStaff:name`  
`DMPStaff:mbox`

### Data characteristics ###

- What kinds of data/source code will be generated or reused (type, format, volume)?  
`Dataset:type`   
`Distribution:format`   
`Distribution:byteSize`   

- How will the research data be generated and which methods will be used?  
`Dataset:description` 

- How will you structure the data and handle versioning?  
`Dataset:description` 

- Who is the target audience?  
`Metadata: IT:TargeAudience` 

**Documentation and Metadata**

- What metadata standards (if any) will be in use and why? (see Digital Curation Centre)  
`Metadata: IT:MetadataStandard` 

- What information is needed for the data to be findable, accessible, interoperable and re-usable (FAIR) in the future?  
`Metadata: IT:make_data_FAIR` 

- Is the data machine-readable?  
`Metadata: IT:machine_readable` 

- How are you planning to document this information?  
`Metadata: IT:information_documentation`  

- What quality assurance processes will you adopt?  
`Dataset:dataQualityAssurance` 

- How will the consistency and quality of data collection be controlled and documented? (This may include processes such as repeat samples or measurements, standardised data capture, peer review of data or representation with controlled vocabularies.)  
`Dataset:dataQualityAssurance` 

### Data Availability and Storage ###

- How and when will the data be shared and made accessible?  
`Distribution:DataAccess`  
`Licence:startDate`

- What repository will you be using?  
`Host:title`

- What persistent identifier will be used?  
`Dataset:datasetID`

- What data are to be preserved for the long-term, and what data will not be stored?  
`Dataset:preservationStatement`

- How and where will the data be stored and backed up during the research?  
`Host:storage_type`  

- How and where will the data be stored after the project ends?  
`Host:title`  

- For how long will the data be stored?   
`Distribution:availableTill`  

- Are there any costs that need to be covered for storage?  
`Cost:costType`  
`Cost:costValue`  
`Cost:costUnit`  

- At what point during or after the project will the data be stored?  
`Dataset:description`  

- Are there any technical barriers to making the research data fully or partially accessible?  
`Metadata: IT:technical_barriers`  

### Legal and Ethical Aspects ###

- Are there any legal barriers to making the research data fully or partially accessible?  
`Dataset:personalData`   
`Dataset:sensitiveData`  

- Who owns the data?  
`Metadata: IT:owner_statement`   

- What licence for reuse are you planning to attach to the data?  
`Licence:ref`   

- Are there any restrictions on the re-use of the data? If so, why?   
`Metadata: IT:data_reuse_restrictions`   

- Are there any ethical barriers to making the research data fully or partially accessible?  
`DMP:ethicalIssuesExist`   
`DMP:ethicalIssuesReport`   
`DMP:ethicalIssuesDescription`   

- If applicable, how are you planning to deal with sensitive data during and after the project?  
`SecurityAndPrivacy:title`   
`SecurityAndPrivacy:desc`   




# How the Tool works and its Configuration

To run the tool first a connection to the mysql database has to be made. Therefore, go to the ```src\main\resources\application.properties``` file. Here you find three values to configure:
```
spring.datasource.url=jdbc:mysql://localhost:3306/DATABASE-NAME?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Vienna
spring.datasource.username=DATABASE-USERNAME
spring.datasource.password=DATABASE-USERPASSWORD
```
Replace ```DATABASE-NAME``` with the name given to the Roadmap database. Then set the username and the (if required) password.

With this the configuration is done. Upon starting the application a website under ```localhost:8080``` can be accessed. 

Here all available DMPs are represented. Simply click the Download button to get the maDMP.

