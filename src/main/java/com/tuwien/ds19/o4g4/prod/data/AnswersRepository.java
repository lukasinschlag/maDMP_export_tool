package com.tuwien.ds19.o4g4.prod.data;

import com.tuwien.ds19.o4g4.prod.data.entity.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswersRepository extends CrudRepository<Answer, Integer> {
}
