package com.abcd.lol.controller;

import com.abcd.lol.domain.Arrival;
import com.abcd.lol.repository.ArrivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("arrive")
public class ArrivalController {

    @Autowired
    private ArrivalRepository arrivalRepository;



    @RequestMapping("arrivals")
    public ModelAndView showAll(Map<String, Object> model){
        Iterable<Arrival> arrivals = arrivalRepository.findAll();
        model.put("arrivals", arrivals);
        return new ModelAndView("main", model);
    }

    @RequestMapping(method = POST)
    public ModelAndView add(@RequestParam String text, @RequestParam String date, Map<String, Object> model){
        Arrival arrival = new Arrival(text, date);

        arrivalRepository.save(arrival);

        Iterable<com.abcd.lol.domain.Arrival> arrivals = arrivalRepository.findAll();
        model.put("arrivals", arrivals);

        return new ModelAndView("main", model);
    }

    @RequestMapping(value = "/filter", method = POST)
    public ModelAndView filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Arrival> arrivals;
        if(filter !=null && !filter.isEmpty()){
            arrivals = arrivalRepository.findByDate(filter);
        } else {
            arrivals = arrivalRepository.findAll();
        }
        model.put("arrivals", arrivals);

        return new ModelAndView("main", model);
    }

    @RequestMapping(method = POST, value = "/delete")
    public ModelAndView delete(@RequestParam Integer id, Map<String, Object> model){
        arrivalRepository.deleteById(id);
        Iterable<com.abcd.lol.domain.Arrival> arrivals = arrivalRepository.findAll();
        model.put("arrivals", arrivals);
        return new ModelAndView("main", model);
    }

//    @GetMapping("/")
//    public String greeting(Map<String, Object> model) {
//        return "greeting";
//    }
//
//    @GetMapping("main")
//    public String main(Map<String, Object> model){
//        Iterable<Arrival> arrivals = arrivalRepository.findAll();
//        model.put("arrivals", arrivals);
//        return "main";
//    }
//
//    @PostMapping("main")
//    public String add(@RequestParam String text, @RequestParam String date, Map<String, Object> model){
//        Arrival arrival = new Arrival(text, date);
//
//        arrivalRepository.save(arrival);
//
//        Iterable<com.abcd.lol.domain.Arrival> arrivals = arrivalRepository.findAll();
//        model.put("arrivals", arrivals);
//
//        return "main";
//    }
//
//    @PostMapping("delete")
//    public String delete(@RequestParam Integer id, Map<String, Object> model){
//        arrivalRepository.deleteById(id);
//        Iterable<com.abcd.lol.domain.Arrival> arrivals = arrivalRepository.findAll();
//        model.put("arrivals", arrivals);
//        return "main";
//    }
//
//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        Iterable<Arrival> arrivals;
//        if(filter !=null && !filter.isEmpty()){
//            arrivals = arrivalRepository.findByDate(filter);
//        } else {
//            arrivals = arrivalRepository.findAll();
//        }
//        model.put("arrivals", arrivals);
//
//        return "main";
//    }

//    private Map<String, Object> sorting(Map<String, Object> model){
//
//    }
//
//    @PostMapping("sort")
//    public String sort(@RequestParam String sortby, Map<String, Object> model){
//        Iterable<Arrival> arrivals;
//        arrivals = arrivalRepository.findAll();
//        model.put("arrivals", arrivals);
//        if(sortby == "asc"){
//            model.entrySet().stream().sorted()
//        } else {
//
//        }
//    }

}
