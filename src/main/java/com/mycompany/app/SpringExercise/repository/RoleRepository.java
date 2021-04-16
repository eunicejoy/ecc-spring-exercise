package com.mycompany.app.SpringExercise.repository;

import com.mycompany.app.SpringExercise.core.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
