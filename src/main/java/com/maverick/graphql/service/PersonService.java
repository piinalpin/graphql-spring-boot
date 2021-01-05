package com.maverick.graphql.service;

import com.maverick.graphql.model.PersonModel;
import com.maverick.graphql.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonModel save(PersonModel person) {
        return personRepository.save(person);
    }

    public List<PersonModel> getAll() {
        return personRepository.findAll();
    }

    public PersonModel getByIdentityNumber(String identityNumber) {
        return personRepository.findByIdentityNumber(identityNumber);
    }

    public Optional<PersonModel> getById(Long id) {
        return personRepository.findById(id);
    }

    public void deletePerson(Long id) {
        personRepository.softDelete(id);
    }

}
