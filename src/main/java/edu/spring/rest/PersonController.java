package edu.spring.rest;

import edu.spring.domain.Person;
import edu.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @RequestMapping(
            value = "/person",
            method = RequestMethod.GET
    )
    public List<PersonDto> get() {
        return service.findAll().stream()
                .map(PersonDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/person/{id}")
    public PersonDto get(@PathVariable("id") int id) {
        Person person = service.getOneById(id);
        return PersonDto.toDto(person);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/person/")
    public PersonDto create(@RequestBody PersonDto dto) {
        Person account = PersonDto.toDomainObject(dto);
        Person accountWithId = service.save(account);
        return PersonDto.toDto(accountWithId);
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable("id") int id) {
        service.deleteById(id);
    }

    @PutMapping("/person/{id}/holder")
    public void changeName(
            @PathVariable("id") int id,
            @RequestParam("name") String name
    ) {
        Person person = service.getOneById(id);
        person.setName(name);
        service.save(person);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotEnoughFunds(NotFoundException ex) {
        return ResponseEntity.badRequest().body("Not found");
    }
}
