package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.model.Passport;
import org.hartford.mappingdemo.model.Person;
import org.hartford.mappingdemo.repository.PassportRepository;
import org.hartford.mappingdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class PassportService {
    @Autowired
    PassportRepository passportRepository;
    @Autowired
    PersonRepository personRepository;
    public List<Passport> findAll(){

        return passportRepository.findAll();
    }

    public Passport getById(Long id){
//        return passportRepository.findById(id).orElse(null);
        return passportRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));

    }

    public Passport addPassport(Passport passport){
        Person p=passport.getPerson();
        if(p==null){
            return passportRepository.save(passport);
        }
        p=personRepository.save(p);
        passport.setPerson(p);
        return passportRepository.save(passport);
    }

    public Person getPersonByPasswordId(Long id){
        Passport passport=passportRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
        return passport.getPerson();
    }

    public Passport bindPersonToPassport(Long passportId,Long personId){
        Passport passport=passportRepository.findById(passportId).orElseThrow(()->new RuntimeException("Invalid id"));
        Person person=personRepository.findById(personId).orElseThrow(()->new RuntimeException("Invalid id"));
        passport.setPerson(person);
        return passportRepository.save(passport);
    }

}
