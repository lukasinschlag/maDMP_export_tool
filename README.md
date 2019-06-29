# maDMP_export_tool


# Mapping of questions to maDMP fields

## FWF  
**Data Officer**

- Who is responsible for the data management and the DMP of the project (name/email address)?  
`DMPStaff:name`  
`DMPStaff:mbox`

**Data characteristics**

- What kinds of data/source code will be generated or reused (type, format, volume)?  
`Dataset:type`   
`Distribution:format`   
`Distribution:byteSize`   

- How will the research data be generated and which methods will be used?  
`Metadata: IT:DataGeneration` 

- How will you structure the data and handle versioning?  
`Dataset: Desc` 

- Who is the target audience?  
`Metadata: IT:TargeAudience` 

**Documentation and Metadata**

- What metadata standards (if any) will be in use and why? (see Digital Curation Centre)  
`Metadata: IT:MetadataStandard` 

- What information is needed for the data to be findable, accessible, interoperable and re-usable (FAIR) in the future?  
`Metadata: IT:makeDataFAIR` 

- Is the data machine-readable?  
`Metadata: IT:MachineReadable` 

- How are you planning to document this information?  
`TODO`  

- What quality assurance processes will you adopt?  
`Dataset:dataQualityAssurance` 

- How will the consistency and quality of data collection be controlled and documented? (This may include processes such as repeat samples or measurements, standardised data capture, peer review of data or representation with controlled vocabularies.)  
`Dataset:dataQualityAssurance` 

**Data Availability and Storage**

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
`Host:title`  
`Host:backupType`  

- How and where will the data be stored after the project ends?  
`TODO`  
`Host:title`  
`Host:backupType`  

- For how long will the data be stored?   
`Distribution:availableTill`  

- Are there any costs that need to be covered for storage?  
`Cost:costType`  
`Cost:costValue`  
`Cost:costUnit`  

- At what point during or after the project will the data be stored?  
`Licence:startDate`  

- Are there any technical barriers to making the research data fully or partially accessible?  
`Metadata: IT:TechnicalBarriers`  

**Legal and Ethical Aspects**

- Are there any legal barriers to making the research data fully or partially accessible?  
`Dataset:personalData`   
`Dataset:sensitiveData`  

- Who owns the data?  
`Metadata: IT:OwnerStatement`   

- What licence for reuse are you planning to attach to the data?  
`Licence:ref`   

- Are there any restrictions on the re-use of the data? If so, why?   
`Metadata: IT:data_reuse_restriction`   

- Are there any ethical barriers to making the research data fully or partially accessible?  
`DMP:ethicalIssuesExist`   
`DMP:ethicalIssuesReport`   
`DMP:ethicalIssuesDescription`   

- If applicable, how are you planning to deal with sensitive data during and after the project?  
`SecurityAndPrivacy:title`   
`SecurityAndPrivacy:desc`   













