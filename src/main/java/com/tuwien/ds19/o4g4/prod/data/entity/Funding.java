package com.tuwien.ds19.o4g4.prod.data.entity;

public class Funding {

    private Funder_id funder_id;

    public Funding(Funder_id funder_id) {
        this.funder_id = funder_id;
    }

    public Funder_id getFunder_id() {
        return funder_id;
    }

    public void setFunder_id(Funder_id funder_id) {
        this.funder_id = funder_id;
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

}
