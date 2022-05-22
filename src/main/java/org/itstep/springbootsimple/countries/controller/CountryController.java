package org.itstep.springbootsimple.countries.controller;


import org.itstep.springbootsimple.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CountryController {

    @Autowired
    private org.itstep.springbootsimple.countries.service.CountryService CountryService;

    @GetMapping("/countries/all")
    public ModelAndView getCountries(){
        var countries = (List<Country>) CountryService.findAll();
        var params = new HashMap<String, Object>();
        params.put("countries", countries);
        return new ModelAndView("showCountriesPage", params);
    }

    @GetMapping("/countries_a")
    public ModelAndView getCountriesA(){
        var countries = (List<Country>) CountryService.findAll();
        var countriesA = countries.stream().filter(country->country.getName().charAt(0)=='A').collect(Collectors.toList());
        var params = new HashMap<String, Object>();
        params.put("countries", countriesA);
        return new ModelAndView("showCountriesA", params);
    }

    @GetMapping("/countries/pageable")
    public ModelAndView getCountries( @RequestParam(defaultValue = "-1") int page,
                                      @RequestParam(defaultValue = "10") int size){

        List<Country> countries = (List<Country>) CountryService.findAll(page,size);
        var params = new HashMap<String, Object>();
        params.put("countries", countries);
        return new ModelAndView("showCountriesPage", params);
    }

}
