package com.mycompany.app.SpringExercise.controller;

import com.mycompany.app.SpringExercise.ResourceNotFoundException;
import com.mycompany.app.SpringExercise.core.model.Person;
import com.mycompany.app.SpringExercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> listPersons(){
        return personRepository.findAll();
    }

    @PostMapping("/persons")
    public Person addPerson(@Valid @RequestBody Person person){
        return personRepository.save(person);
    }

    @PutMapping("persons/{id}")
    public Person updatePerson(@PathVariable(value="id") Integer personId,
                                               @Valid @RequestBody Person personDetails)  {

        Person person = personRepository.findById(personId)
                .orElseThrow(()-> new ResourceNotFoundException("Person with id" + personId +"does not exist."));

        if(personDetails.getFirstName() == ""){
            person.setFirstName(person.getFirstName());
        } else{
            person.setFirstName(personDetails.getFirstName());
        }

        if(personDetails.getLastName() == ""){
            person.setLastName(person.getLastName());
        } else{
            person.setLastName(personDetails.getLastName());
        }

        if(personDetails.getMiddleName() == ""){
            person.setMiddleName(person.getMiddleName());
        } else{
            person.setMiddleName(personDetails.getMiddleName());
        }

        if(personDetails.getSuffix() == ""){
            person.setSuffix(person.getSuffix());
        } else{
            person.setSuffix(personDetails.getSuffix());
        }

        if(personDetails.getStreetNumber() == null){
            person.setStreetNumber(person.getStreetNumber());
        } else{
            person.setStreetNumber(personDetails.getStreetNumber());
        }

        if(personDetails.getBarangay() == ""){
            person.setBarangay(person.getBarangay());
        } else{
            person.setBarangay(personDetails.getBarangay());
        }

        if(personDetails.getMunicipalityOrCity() == ""){
            person.setMunicipalityOrCity(person.getMunicipalityOrCity());
        } else{
            person.setMunicipalityOrCity(personDetails.getMunicipalityOrCity());
        }

        if(personDetails.getZipcode() == null){
            person.setZipcode(person.getZipcode());
        } else{
            person.setZipcode(personDetails.getZipcode());
        }

        if(personDetails.getBirthday() == null){
            person.setBirthday(person.getBirthday());
        } else{
            person.setBirthday(personDetails.getBirthday());
        }

        if(personDetails.getGeneralWeightedAverage() == null){
            person.setGeneralWeightedAverage(person.getGeneralWeightedAverage());
        } else{
            person.setGeneralWeightedAverage(personDetails.getGeneralWeightedAverage());
        }

        if(personDetails.getDateHired() == null){
            person.setDateHired(person.getDateHired());
        } else{
            person.setDateHired(personDetails.getDateHired());
        }

        if(personDetails.getCurrentlyEmployed() == ""){
            person.setCurrentlyEmployed(person.getCurrentlyEmployed());
        } else{
            person.setCurrentlyEmployed(personDetails.getCurrentlyEmployed());
        }

        Person updatedPerson = personRepository.save(person);

        return  updatedPerson;
    }

    @DeleteMapping("persons/{id}")
    public String deletePerson(@PathVariable(value="id") Integer personId){

        Person person = personRepository.findById(personId)
                .orElseThrow(()-> new ResourceNotFoundException("Person with id" + personId +"does not exist."));

        personRepository.delete(person);

        return "Person with id "+ personId + " has been deleted.";
    }


}
