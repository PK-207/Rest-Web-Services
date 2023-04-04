package com.in28minutes.rest.restfulwebservices.api;

import com.in28minutes.rest.restfulwebservices.model.Person;
import com.in28minutes.rest.restfulwebservices.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person){
         personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPerson(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable UUID id){
        personService.deleteById(id);
    }
@PutMapping("/{id}")
    public void updatePersonById(@PathVariable ("id") UUID id, @Valid @NonNull @RequestBody Person newPerson){
      personService.updatePerson(id,newPerson);
    }
}
