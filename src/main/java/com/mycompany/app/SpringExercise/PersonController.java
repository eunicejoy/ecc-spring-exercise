package com.mycompany.app.SpringExercise;

import com.mycompany.app.SpringExercise.core.model.Person;
import com.mycompany.app.SpringExercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @PostMapping("/person")
    public Person addPerson(@Valid @RequestBody Person person){
        return personRepository.save(person);
    }


}
