package com.maverick.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.maverick.graphql.exception.DataNotFoundException;
import com.maverick.graphql.form.PersonForm;
import com.maverick.graphql.model.PersonModel;
import com.maverick.graphql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonMutation implements GraphQLMutationResolver {

    private final PersonService personService;

    @Autowired
    public PersonMutation(PersonService personService) {
        this.personService = personService;
    }

    public PersonModel createPerson(PersonForm form) {
        PersonModel person = PersonModel.builder()
                .address(form.getAddress())
                .dateOfBirth(Timestamp.valueOf(form.getDateOfBirth().atStartOfDay()))
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .identityType(form.getIdentityType())
                .identityNumber(form.getIdentityNumber())
                .build();
        return personService.save(person);
    }

    public PersonModel updatePerson(PersonForm form, Long id) {
        PersonModel person = personService.getById(id).orElse(null);
        if (person == null) throw new DataNotFoundException("person record: not found");
        person.setAddress(form.getAddress());
        person.setDateOfBirth(Timestamp.valueOf(form.getDateOfBirth().atStartOfDay()));
        person.setFirstName(form.getFirstName());
        person.setLastName(form.getLastName());
        person.setIdentityNumber(form.getIdentityNumber());
        person.setIdentityType(form.getIdentityType());
        return personService.save(person);
    }

    public Map<String, String> deletePerson(Long id) {
        PersonModel person = personService.getById(id).orElse(null);
        if (person == null) throw new DataNotFoundException("person record: not found");

        personService.deletePerson(person.getId());
        Map<String,String> ret = new HashMap<>();
        ret.put("message", "ok");

        return ret;
    }

}
