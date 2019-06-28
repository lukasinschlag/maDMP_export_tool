package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class Dataset_Id implements TypedIdentifier {

    private String dataset_id;
    private String dataset_id_type;

    public Dataset_Id(String dataset_id) {
        this.dataset_id = dataset_id;
    }

    public String getdataset_id() {
        return dataset_id;
    }

    public void setdataset_id(String dataset_id) {
        this.dataset_id = dataset_id;
    }

    public String getdataset_id_type() {
        return dataset_id_type;
    }

    public void setdataset_id_type(String dataset_id_type) {
        this.dataset_id_type = dataset_id_type;
    }
}
