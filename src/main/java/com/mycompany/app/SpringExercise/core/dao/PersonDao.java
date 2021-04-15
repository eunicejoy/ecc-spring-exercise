package com.mycompany.app.SpringExercise.core.dao;

import com.mycompany.app.SpringExercise.core.model.Person;

public interface PersonDao {
    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
}
