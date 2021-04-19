package com.mycompany.app.SpringExercise.controller;

import com.mycompany.app.SpringExercise.ResourceNotFoundException;
import com.mycompany.app.SpringExercise.core.model.Contact;
import com.mycompany.app.SpringExercise.core.model.Person;
import com.mycompany.app.SpringExercise.core.model.PersonRole;
import com.mycompany.app.SpringExercise.repository.PersonContactRepository;
import com.mycompany.app.SpringExercise.repository.PersonRepository;
import com.mycompany.app.SpringExercise.repository.PersonRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonContactRepository personContactRepository;

    @Autowired
    private PersonRoleRepository personRoleRepository;

    @GetMapping("/persons")
    public List<Person> listPersons(){
        return personRepository.findAll();
    }

    @GetMapping("/persons/gwa/asc")
    public List<Person> listPersonByGWA(){
        return personRepository.listPersonByGWA();
    }

    @GetMapping("/persons/gwa/desc")
    public List<Person> listPersonByGWADesc(){
        return personRepository.listPersonByGWADesc();
    }

    @GetMapping("/persons/datehired/asc")
    public List<Person> listPersonByDateHired(){
        return personRepository.listPersonByDateHired();
    }

    @GetMapping("/persons/datehired/desc")
    public List<Person> listPersonByDateHiredDesc(){
        return personRepository.listPersonByDateHiredDesc();
    }

    @GetMapping("/persons/lastname/asc")
    public List<Person> listPersonByLastName(){
        return personRepository.listPersonByLastName();
    }

    @GetMapping("/persons/lastname/desc")
    public List<Person> listPersonByLastNameDesc(){
        return personRepository.listPersonByLastNameDesc();
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

        if(personDetails.getFirstName().equals("")){
            person.setFirstName(person.getFirstName());
        } else{
            person.setFirstName(personDetails.getFirstName());
        }

        if(personDetails.getLastName().equals("")){
            person.setLastName(person.getLastName());
        } else{
            person.setLastName(personDetails.getLastName());
        }

        if(personDetails.getMiddleName().equals("")){
            person.setMiddleName(person.getMiddleName());
        } else{
            person.setMiddleName(personDetails.getMiddleName());
        }

        if(personDetails.getSuffix().equals("")){
            person.setSuffix(person.getSuffix());
        } else{
            person.setSuffix(personDetails.getSuffix());
        }

        if(personDetails.getStreetNumber() == null){
            person.setStreetNumber(person.getStreetNumber());
        } else{
            person.setStreetNumber(personDetails.getStreetNumber());
        }

        if(personDetails.getBarangay().equals("")){
            person.setBarangay(person.getBarangay());
        } else{
            person.setBarangay(personDetails.getBarangay());
        }

        if(personDetails.getMunicipalityOrCity().equals("")){
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

        if(personDetails.getCurrentlyEmployed().equals("")){
            person.setCurrentlyEmployed(person.getCurrentlyEmployed());
        } else{
            person.setCurrentlyEmployed(personDetails.getCurrentlyEmployed());
        }

        return personRepository.save(person);
    }

    @DeleteMapping("persons/{id}")
    public String deletePerson(@PathVariable(value="id") Integer personId){

        Person person = personRepository.findById(personId)
                .orElseThrow(()-> new ResourceNotFoundException("Person with id" + personId +"does not exist."));

        personRepository.delete(person);

        return "Person with id "+ personId + " has been deleted.";
    }

    @GetMapping("persons/{id}/contacts")
    public Person personContactList(@PathVariable(value = "id") Integer personId){
        return personRepository.findById(personId).get();
    }

    @PostMapping("persons/{id}/contacts")
    public Contact addContact(@PathVariable(value = "id") Integer personId, @Valid @RequestBody Contact contact){
        contact.setPersonId(personId);
        return personContactRepository.save(contact);
    }

    @PutMapping("persons/{id}/contacts/{contact_id}")
    public Contact updateContact(@PathVariable(value="id") Integer personId,
                                 @PathVariable(value = "contact_id") Integer contactId,
                                 @Valid @RequestBody Contact contactDetails){
        Person person = personRepository.findById(personId).orElseThrow(()-> new ResourceNotFoundException("Person with id " + personId + " does not exist."));
        Contact contact = personContactRepository.findById(contactId).orElseThrow(()-> new ResourceNotFoundException(("Contact does not exist")));

        contact.setPersonId(contact.getPersonId());
        contact.setContactType(contactDetails.getContactType());
        contact.setContactValue(contactDetails.getContactValue());

        return personContactRepository.save(contact);
    }

    @DeleteMapping("persons/{id}/contacts/{contact_id}")
    public String deleteContact(@PathVariable(value="id") Integer personId,
                                @PathVariable(value = "contact_id") Integer contactId){

        Person person = personRepository.findById(personId).orElseThrow(()-> new ResourceNotFoundException("Person with id " + personId + " does not exist."));
        Contact contact = personContactRepository.findById(contactId).orElseThrow(()-> new ResourceNotFoundException(("Contact does not exist")));

        personContactRepository.delete(contact);
        return "Contact has been deleted";
    }

    @PostMapping("persons/{id}/roles")
    public PersonRole addPersonRole(@PathVariable(value = "id") Integer personId, @Valid @RequestBody PersonRole personRole){
        personRole.setPersonId(personId);

        return personRoleRepository.save(personRole);
    }


    @DeleteMapping("persons/{id}/roles/{role_id}")
    public String deletePersonRole(@PathVariable(value="id") Integer personId,
                                @PathVariable(value = "role_id") Integer roleId){

        Person person = personRepository.findById(personId).orElseThrow(()-> new ResourceNotFoundException("Person with id " + personId + " does not exist."));
        PersonRole personRole = personRoleRepository.findById(roleId).orElseThrow(()-> new ResourceNotFoundException(("Role does not exist")));

        personRoleRepository.delete(personRole);
        return "Role has been deleted";
    }


}
