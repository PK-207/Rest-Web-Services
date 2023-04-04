package com.in28minutes.rest.restfulwebservices.service;

import com.in28minutes.rest.restfulwebservices.dao.PersonDao;
import com.in28minutes.rest.restfulwebservices.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

   private final PersonDao personDao;
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPerson(){
        return personDao.getAllPerson();
    }

    public Optional<Person> getPerson(UUID id){
        return personDao.selectPerson(id);
    }

    public int deleteById(UUID id){
         return personDao.deletePerson(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.update(id, newPerson);
    }
}
