package com.tuwien.ds19.o4g4.prod;

import com.google.gson.Gson;
import com.tuwien.ds19.o4g4.prod.data.AnswersRepository;
import com.tuwien.ds19.o4g4.prod.data.DMPJSON;
import com.tuwien.ds19.o4g4.prod.data.PlanRepository;
import com.tuwien.ds19.o4g4.prod.data.entity.Answer;
import com.tuwien.ds19.o4g4.prod.data.entity.DMP;
import com.tuwien.ds19.o4g4.prod.data.entity.Plan;
import com.tuwien.ds19.o4g4.prod.data.entity.RoadmapSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(path="/")
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    private final AnswersRepository answersRepository;
    private final PlanRepository planRepository;

    private final LoadPlansService loadPlansService;

    private RoadmapSet set;
    private List<Plan> planList;

    public Controller(AnswersRepository answersRepository, PlanRepository planRepository, LoadPlansService loadPlansService) {
        this.answersRepository = answersRepository;
        this.planRepository = planRepository;
        this.loadPlansService = loadPlansService;
    }

    @GetMapping(path = "/")
    public RedirectView main(){

        // Load available plans
        planList = new ArrayList<>();
        planRepository.findAll().iterator().forEachRemaining(planList::add);

        List<Answer> answerList = new ArrayList<>();
        answersRepository.findAll().iterator().forEachRemaining(answerList::add);
        set = new RoadmapSet(planList);

        logger.debug(answerList.get(0).toString());

        return new RedirectView("/home");
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("home", "set", set);
    }

    @GetMapping(path = "/json")
    public String getJsonTest(){
        DMP dmp = loadPlansService.loadIntoDMP(planList.get(4));
        Gson gson = new Gson();
        return gson.toJson(new DMPJSON(dmp));
    }

    @RequestMapping(value = "/json/{plan_id}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("plan_id") String plan,
            HttpServletResponse response) {
        try {
            if(planRepository.findById(Integer.parseInt(plan)).isPresent()) {
                DMP dmp = loadPlansService.loadIntoDMP(planRepository.findById(Integer.parseInt(plan)).get());

                Gson gson = new Gson();
                String json = gson.toJson(new DMPJSON(dmp));

                InputStream is = new ByteArrayInputStream(json.getBytes());
                org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
                response.flushBuffer();
            }
        } catch (IOException ex) {
            logger.info("Error writing file to output stream. Filename was '{}'", plan, ex);
            throw new RuntimeException("IOError writing file to output stream");
        }

    }

    @RequestMapping(value="/json2/{plan_id}", method=RequestMethod.GET)
    public ResponseEntity<byte[]> getJson(@PathVariable("plan_id") String plan) {
        DMP dmp = loadPlansService.loadIntoDMP(planRepository.findById(Integer.parseInt(plan)).get());

        Gson gson = new Gson();
        String js = gson.toJson(new DMPJSON(dmp));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String filename = "maDMP.json";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(js.getBytes(), headers, HttpStatus.OK);
    }
}
