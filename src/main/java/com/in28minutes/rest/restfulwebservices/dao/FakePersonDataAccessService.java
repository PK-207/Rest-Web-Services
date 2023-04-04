package com.in28minutes.rest.restfulwebservices.dao;

import com.in28minutes.rest.restfulwebservices.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements  PersonDao{

    private static List<Person> DB =new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    public List<Person> getAllPerson(){
        return DB;
    }

    @Override
    public Optional<Person> selectPerson(UUID id) {
        return Optional.ofNullable(DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .get());
    }

    @Override
    public int deletePerson(UUID id) {
        System.out.println("inside deletePerson ");
        Optional<Person> personMaybe= selectPerson(id);
        if(personMaybe.isEmpty())
            return 0;
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int update(UUID id, Person update) {
        selectPerson(id)
                .map(person -> {
                    int indexofpersonToUpdate = DB.indexOf(person);
                    if (indexofpersonToUpdate >= 0) {
                        DB.set(indexofpersonToUpdate, new Person(id,update .getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);

        return 0;
    }
}
