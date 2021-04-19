package com.mycompany.app.SpringExercise.repository;

import com.mycompany.app.SpringExercise.core.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonContactRepository extends JpaRepository<Contact, Integer> {



}
