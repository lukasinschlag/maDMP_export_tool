package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class Funding {

    private Funder_id funderID;
    private Grant_id grantID;

    public Funding() {}

    public Funder_id getFunderID() {
        return funderID;
    }

    public void setFunderID(String funderID) {
        String type = "TEXT";
        if(funderID.toLowerCase().contains("orcid")){
            type = "HTTP-ORCID";
        } else if(funderID.toLowerCase().contains("http")){
            type = "HTTP";
        }
        this.funderID = new Funder_id(funderID, type);
    }

    public Grant_id getGrantID() {
        return grantID;
    }

    public void setGrantID(String grantID) {
        String type = "TEXT";
        if(grantID.toLowerCase().contains("orcid")){
            type = "HTTP-ORCID";
        } else if(grantID.toLowerCase().contains("http")){
            type = "HTTP";
        } else if(grantID.matches("\\d+")){
            type = "NUMBER";
        }
        this.grantID = new Grant_id(grantID, type);
    }

    class Funder_id {

        private String funder_id;
        private String funder_id_type;

        public Funder_id(String funder_id, String funder_id_type) {
            this.funder_id = funder_id;
            this.funder_id_type = funder_id_type;
        }

        public String getFunder_id() {
            return funder_id;
        }

        public void setFunder_id(String funder_id) {
            this.funder_id = funder_id;
        }

        public String getFunder_id_type() {
            return funder_id_type;
        }

        public void setFunder_id_type(String funder_id_type) {
            this.funder_id_type = funder_id_type;
        }
    }

    class Grant_id {

        private String grant_id;
        private String grant_id_type;

        public Grant_id(String grant_id, String grant_id_type) {
            this.grant_id = grant_id;
            this.grant_id_type = grant_id_type;
        }

        public String getGrant_id() {
            return grant_id;
        }

        public void setGrant_id(String grant_id) {
            this.grant_id = grant_id;
        }

        public String getGrant_id_type() {
            return grant_id_type;
        }

        public void setGrant_id_type(String grant_id_type) {
            this.grant_id_type = grant_id_type;
        }
    }
}
