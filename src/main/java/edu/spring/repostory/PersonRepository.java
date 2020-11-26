package edu.spring.repostory;

import org.springframework.data.repository.PagingAndSortingRepository;
import edu.spring.domain.Person;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

    List<Person> findAll();
}
