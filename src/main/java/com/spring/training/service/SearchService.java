package com.spring.training.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.spring.training.domain.Person;

@Service
public class SearchService {

    @Value("${services.persons}")
    private String personService;

    public Person search(Long id) {
        RestTemplate template = new RestTemplate();
        return template.getForObject(personService+"/"+id, Person.class);
    }
}
