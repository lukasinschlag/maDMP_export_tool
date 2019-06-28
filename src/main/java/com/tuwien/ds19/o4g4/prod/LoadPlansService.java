package com.tuwien.ds19.o4g4.prod;

import com.tuwien.ds19.o4g4.prod.data.PlanRepository;
import com.tuwien.ds19.o4g4.prod.data.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadPlansService {

    private final PlanRepository planRepository;

    public LoadPlansService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public RoadmapSet getAllPlans(){

        List<Plan> planList = new ArrayList<>();
        planRepository.findAll().iterator().forEachRemaining(planList::add);

        return new RoadmapSet(planList);
    }

    public Plan findById(int id){
        if(planRepository.findById(id).isPresent()){
            return planRepository.findById(id).get();
        }
        return null;
    }

    public Plan findById(String id){
        return findById(Integer.parseInt(id));
    }
}
