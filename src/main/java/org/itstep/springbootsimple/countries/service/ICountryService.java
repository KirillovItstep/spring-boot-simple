package org.itstep.springbootsimple.countries.service;


import org.itstep.springbootsimple.countries.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICountryService {
    List<Country> findAll();
    public Country findOne(Long id);
    public void saveAll(List<Country> countries);
}