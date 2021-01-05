package com.maverick.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.maverick.graphql.exception.DataNotFoundException;
import com.maverick.graphql.model.PersonModel;
import com.maverick.graphql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonResolver implements GraphQLQueryResolver {

    private final PersonService personService;

    @Autowired
    public PersonResolver(PersonService personService) {
        this.personService = personService;
    }

    public List<PersonModel> getAllPerson() {
        return personService.getAll();
    }

    public PersonModel getPersonById(final Long id) {
        PersonModel person = personService.getById(id).orElse(null);
        if (person == null) throw new DataNotFoundException("person record: not found");
        return person;
    }

    public PersonModel getPersonByIdentityNumber(final String identityNumber) {
        PersonModel person = personService.getByIdentityNumber(identityNumber);
        if (person == null) throw new DataNotFoundException("person record: not found");
        return person;
    }

}
