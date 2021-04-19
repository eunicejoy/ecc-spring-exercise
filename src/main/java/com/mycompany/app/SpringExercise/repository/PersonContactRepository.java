package com.mycompany.app.SpringExercise.repository;

import com.mycompany.app.SpringExercise.core.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonContactRepository extends JpaRepository<Contact, Integer> {



}
