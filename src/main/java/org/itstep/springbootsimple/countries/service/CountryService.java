package org.itstep.springbootsimple.countries.service;


import org.itstep.springbootsimple.countries.model.Country;
import org.itstep.springbootsimple.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public void saveAll(List<Country> countries) {
         countryRepository.saveAll(countries);
    }

    @Override
    public Country findOne(Long id) {
        return countryRepository.findById(id).orElse(null);
    }
}
