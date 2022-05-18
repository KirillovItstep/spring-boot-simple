package org.itstep.springbootsimple.countries.repository;


import org.itstep.springbootsimple.countries.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
}
