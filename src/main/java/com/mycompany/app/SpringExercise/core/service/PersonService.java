package com.mycompany.app.SpringExercise.core.service;

import com.mycompany.app.SpringExercise.core.model.Person;

public interface PersonService {
    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
}
