package com.tuwien.ds19.o4g4.prod;

import com.tuwien.ds19.o4g4.prod.data.entity.Contact;
import com.tuwien.ds19.o4g4.prod.data.entity.Contact_Id;
import com.tuwien.ds19.o4g4.prod.data.entity.DMP;
import com.tuwien.ds19.o4g4.prod.data.entity.Plan;
import org.springframework.stereotype.Service;

@Service
public class LoadPlansService {

    public DMP loadIntoDMP(Plan p){
        DMP newDmp = new DMP();
        newDmp.setTitle(p.getTitle());
        newDmp.setCreated(p.getCreated());
        newDmp.setModified(p.getUpdated());

        setContact(p, newDmp);

        return newDmp;
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
}
