package com.in28minutes.rest.restfulwebservices.dao;

import com.in28minutes.rest.restfulwebservices.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

     int insertPerson(UUID id, Person person);

     default int insertPerson(Person person){
         UUID id=UUID.randomUUID();
         return insertPerson(id,person);
     }

    List<Person> getAllPerson();


     Optional<Person> selectPerson(UUID id);

     int deletePerson(UUID id);

     int update(UUID id, Person person);
}
