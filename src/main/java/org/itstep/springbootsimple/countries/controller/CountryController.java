package org.itstep.springbootsimple.countries.controller;


import org.itstep.springbootsimple.countries.model.Country;
import org.itstep.springbootsimple.countries.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CountryController {

    @Autowired
    private ICountryService iCountryService;

    @GetMapping("/countries")
    public ModelAndView getCountries(){
        System.out.println("ok");
        var countries = (List<Country>) iCountryService.findAll();
        var params = new HashMap<String, Object>();
        params.put("countries", countries);
        return new ModelAndView("showCountries", params);
    }

    @GetMapping("/countries_a")
    public ModelAndView getCountriesA(){
        var countries = (List<Country>) iCountryService.findAll();
        var countriesA = countries.stream().filter(country->country.getName().charAt(0)=='A').collect(Collectors.toList());
        var params = new HashMap<String, Object>();
        params.put("countries", countriesA);
        return new ModelAndView("showCountriesA", params);
    }
}
