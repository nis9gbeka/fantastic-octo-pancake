package com.abcd.lol.controller;

import com.abcd.lol.domain.Role;
import com.abcd.lol.domain.User;
import com.abcd.lol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("")
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    private Map<String, Object> sample = null;

    @RequestMapping("/registration")
    public ModelAndView registration(){

//         model.put(userRepository.findByUsername("1"));
        return new ModelAndView("registration", sample);
    }

    @PostMapping("/registration")
    public ModelAndView addUser(User user, Map<String, Object> model){
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if(userFromDB != null){
            model.put("message", "USER EXISTS");
            return new ModelAndView("registration", sample);
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return new ModelAndView("redirect:/login",sample);
    }
}
