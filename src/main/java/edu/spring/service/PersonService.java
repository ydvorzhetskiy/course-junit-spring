package edu.spring.service;

import edu.spring.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person getOneById(int id);

    Person save(Person person);

    void deleteById(int id);
}
