package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.model.Passport;
import org.hartford.mappingdemo.model.Person;
import org.hartford.mappingdemo.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passports")
public class PassportController {
    @Autowired
    PassportService passportService;

    @PostMapping
    public Passport addPassport(@RequestBody Passport passport){
        return passportService.addPassport(passport);
    }

    @GetMapping("/{id}")
    public Passport getById(@PathVariable Long id){
        return passportService.getById(id);
    }

    @GetMapping("/p/{id}")
    public Person getPersonByPassportId(@PathVariable Long id){
        return passportService.getPersonByPasswordId(id);
    }

    @GetMapping("/bind/{passportId}/{personId}")
    public Passport bindPersonToPassport(@PathVariable Long passportId,@PathVariable Long personId){
        return passportService.bindPersonToPassport(passportId,personId);
    }


}
