package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.model.Passport;
import org.hartford.mappingdemo.model.Person;
import org.hartford.mappingdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    
    public Person addPerson(Person person){
        return personRepository.save(person);
    }
    
    public Person getById(Long id){
        return personRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
    }
    
    public List<Person> findAll(){
        return personRepository.findAll();
    }
    
    public void deleteById(Long id){
        personRepository.deleteById(id);
    }

    public Passport getPersonByPasswordId(Long id){
        Person person=personRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
        return person.getPassport();
    }
}
