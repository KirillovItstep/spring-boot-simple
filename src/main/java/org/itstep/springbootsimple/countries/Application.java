package org.itstep.springbootsimple.countries;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.itstep.springbootsimple.countries.model.Country;
import org.itstep.springbootsimple.countries.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    CommandLineRunner runner(CountryService countryService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            /*
            List<Country> countries = mapper.readValue(Paths.get("src/main/resources/static/countries.json").toFile(),
                    new TypeReference<List<Country>>() {
                    });

            countries.stream().forEach(System.out::println);
             */

            List<Country> countries = mapper.readValue(Paths.get("src/main/resources/static/countries.json").toFile(),
                    new TypeReference<List<Country>>() {
                    });
                countryService.saveAll(countries);
                System.out.println("Countries saved!");
        };
    }
}
