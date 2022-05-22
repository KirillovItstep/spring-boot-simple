package org.itstep.springbootsimple.countries.service;


import org.itstep.springbootsimple.countries.model.Country;
import org.itstep.springbootsimple.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService{

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    public void saveAll(List<Country> countries) {
         countryRepository.saveAll(countries);
    }

    public List<Country> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return (List<Country>) countryRepository.findAll(pageable).getContent();
    }

    public Country findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }
}
