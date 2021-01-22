package edu.spring.service;

import edu.spring.domain.Person;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface PersonService {
    List<Person> findAll();

    Optional<Person> findById(int id);

    Person save(Person person);

    void deleteById(int id);
}
