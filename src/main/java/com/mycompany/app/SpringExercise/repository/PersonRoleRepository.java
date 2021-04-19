package com.mycompany.app.SpringExercise.repository;

import com.mycompany.app.SpringExercise.core.model.PersonRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRoleRepository extends JpaRepository<PersonRole, Integer> {
}
