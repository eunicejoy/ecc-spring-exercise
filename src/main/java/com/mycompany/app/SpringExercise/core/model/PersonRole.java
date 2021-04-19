package com.mycompany.app.SpringExercise.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "personrole")
public class PersonRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_role_id", columnDefinition = "serial")
    private Integer personRoleId;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "role_id")
    private Integer roleId;

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    @JsonBackReference
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

    public PersonRole() {
    }

    public PersonRole(Integer personRoleId, Integer personId, Integer roleId, String roleName) {
        this.personRoleId = personRoleId;
        this.personId = personId;
        this.roleId = roleId;
    }

    public PersonRole(Integer personId, Integer roleId, String roleName) {
        this.personId = personId;
        this.roleId = roleId;
    }

    public Integer getPersonRoleId() {
        return personRoleId;
    }

    public void setPersonRoleId(Integer personRoleId) {
        this.personRoleId = personRoleId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "PersonRole{" +
                "personRoleId=" + personRoleId +
                ", personId=" + personId +
                ", roleId=" + roleId +
                '}';
    }
}
