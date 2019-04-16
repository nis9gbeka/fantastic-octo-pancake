package com.abcd.lol.controller;

import com.abcd.lol.domain.Arrival;
import com.abcd.lol.repository.ArrivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ArrivalRepository arrivalRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("main")
    public String main(Map<String, Object> model){
        Iterable<Arrival> arrivals = arrivalRepository.findAll();
        model.put("arrivals", arrivals);
        return "main";
    }

    @PostMapping("main")
    public String add(@RequestParam String text, @RequestParam String date, Map<String, Object> model){
        Arrival arrival = new Arrival(text, date);

        arrivalRepository.save(arrival);

        Iterable<com.abcd.lol.domain.Arrival> arrivals = arrivalRepository.findAll();
        model.put("arrivals", arrivals);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Arrival> arrivals;
        if(filter !=null && !filter.isEmpty()){
            arrivals = arrivalRepository.findByDate(filter);
        } else {
            arrivals = arrivalRepository.findAll();
        }
        model.put("arrivals", arrivals);

        return "main";
    }

}
