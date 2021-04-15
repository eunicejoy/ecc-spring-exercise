package com.mycompany.app.SpringExercise.repository;

import com.mycompany.app.SpringExercise.core.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Integer> {
}
