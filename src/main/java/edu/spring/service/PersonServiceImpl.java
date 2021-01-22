package edu.spring.service;

import edu.spring.domain.Person;
import edu.spring.repostory.PersonRepository;
import edu.spring.rest.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person getOneById(int id) {
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
