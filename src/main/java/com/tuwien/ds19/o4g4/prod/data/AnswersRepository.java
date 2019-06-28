package com.tuwien.ds19.o4g4.prod.data;

import com.tuwien.ds19.o4g4.prod.data.entity.Answer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswersRepository extends CrudRepository<Answer, Integer> {

    List<Answer> findAllByPlan_id(int id);

    Answer findFirstByPlan_id(int id);
}
