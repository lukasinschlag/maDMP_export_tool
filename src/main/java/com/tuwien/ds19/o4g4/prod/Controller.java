package com.tuwien.ds19.o4g4.prod;

import com.tuwien.ds19.o4g4.prod.data.entity.madmp.DMP;
import com.tuwien.ds19.o4g4.prod.data.entity.RoadmapSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@org.springframework.stereotype.Controller
@RequestMapping(path = "/")
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    private final LoadPlansService loadPlansService;
    private final MaDMPService maDMPService;

    private RoadmapSet set;

    public Controller(LoadPlansService loadPlansService, MaDMPService maDMPService) {
        this.loadPlansService = loadPlansService;
        this.maDMPService = maDMPService;
    }

    @GetMapping(path = "/")
    public RedirectView main() {

        set = loadPlansService.getAllPlans();

        return new RedirectView("/home");
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("home", "set", set);
    }

    @GetMapping(path = "/json")
    public String getJsonTest() { // get the first
        return maDMPService.getJSONDMP(maDMPService.getDMPFromPlan(loadPlansService.findById(1)));
    }

    @RequestMapping(value = "/jsonOLD/{plan_id}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("plan_id") String plan,
            HttpServletResponse response) {
        try {
            DMP dmp = maDMPService.getDMPFromPlan(loadPlansService.findById(plan));
            String json = maDMPService.getJSONDMP(dmp);
            InputStream is = new ByteArrayInputStream(json.getBytes());
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            logger.info("Error writing file to output stream. Filename was '{}'", plan, ex);
            throw new RuntimeException("IOError writing file to output stream");
        }

    }

    @RequestMapping(value = "/json/{plan_id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getJson(@PathVariable("plan_id") String plan) {

        DMP dmp = maDMPService.getDMPFromPlan(loadPlansService.findById(plan));
        String json = maDMPService.getJSONDMP(dmp);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String filename = "maDMP.json";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(json.getBytes(), headers, HttpStatus.OK);
    }
}
