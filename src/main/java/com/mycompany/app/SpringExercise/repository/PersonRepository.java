package com.mycompany.app.SpringExercise.repository;

import com.mycompany.app.SpringExercise.core.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Integer> {

    @Query("FROM Person ORDER BY generalWeightedAverage ASC")
    List<Person> listPersonByGWA();

    @Query("FROM Person ORDER BY generalWeightedAverage DESC")
    List<Person> listPersonByGWADesc();

    @Query("FROM Person ORDER BY dateHired ASC")
    List<Person> listPersonByDateHired();

    @Query("FROM Person ORDER BY dateHired DESC")
    List<Person> listPersonByDateHiredDesc();

    @Query("FROM Person ORDER BY lastName ASC")
    List<Person> listPersonByLastName();

    @Query("FROM Person ORDER BY lastName DESC")
    List<Person> listPersonByLastNameDesc();
}
