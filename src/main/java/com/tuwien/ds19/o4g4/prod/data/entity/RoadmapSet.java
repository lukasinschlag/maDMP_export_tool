package com.tuwien.ds19.o4g4.prod.data.entity;

import java.util.List;

public class RoadmapSet {

    private List<Plan> planList;

    public RoadmapSet(List<Plan> planList) {
        this.planList = planList;
    }

    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }
}
