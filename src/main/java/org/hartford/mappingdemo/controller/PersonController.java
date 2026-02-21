package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.model.Person;
import org.hartford.mappingdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id){
        return personService.getById(id);
    }
    
    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        personService.deleteById(id);
    }
    
//    @PutMapping("/{id}")
//    public Person updatePerson(@PathVariable Long id, @RequestBody Person person){
//        return personService.updatePerson(id, person);
//    }
}
