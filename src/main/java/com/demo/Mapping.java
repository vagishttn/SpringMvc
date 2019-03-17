package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/dummy")
public class Mapping {

    @RequestMapping("/")
    @ResponseBody
    String indexx() {
        return "index string";
    }


    @RequestMapping("/mv")
    ModelAndView mv (){

        return  new ModelAndView("index.jsp").addObject("msg","Hello World");
    }

    @RequestMapping("/country/{countryName}")
    @ResponseBody
    String returnCountryName(@PathVariable("countryName") String countryName) {
        return countryName;
    }

    @RequestMapping("/countryAndState/{countryName}/{stateName}")
    @ResponseBody
    String returnCountryAndState(@PathVariable Map<String, String> requestMap) {
        return requestMap.get("countryName") + " " + requestMap.get("stateName");
    }




    //Answer 6
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("index.html");

        return modelAndView;

    }

    //Answer 7
    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    @ResponseBody
    String submitForm(String username, String password) {
        return "Username " + username + " Password " + password;
    }

}
