package com.spring.training.controller;

import com.spring.training.domain.Person;
import com.spring.training.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SearchController {

    private final SearchService service;

    @GetMapping("persons/{id}")
    public Person getPerson(@PathVariable("id") Long id) {
        return service.search(id);
    }

}
