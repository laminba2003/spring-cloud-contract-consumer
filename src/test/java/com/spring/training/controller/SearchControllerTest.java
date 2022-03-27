package com.spring.training.controller;

import com.spring.training.domain.Person;
import com.spring.training.service.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(ids = {
        "com.spring.training:rest-services:+:stubs:8095"
}
)
class SearchControllerTest {

    @Autowired
    private SearchService service;

    @Test
    void testSearch() throws Exception {
       Person person = service.search(1L);
       assertThat(person.getId()).isEqualTo(1L);
       assertThat(person.getFirstName()).isEqualTo("Mamadou Lamine");
       assertThat(person.getLastName()).isEqualTo("Ba");
    }
}