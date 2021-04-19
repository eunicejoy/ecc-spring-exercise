package com.mycompany.app.SpringExercise.core.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="contact")
public class Contact {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contact_id", columnDefinition = "serial")
    private Integer contactId;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "contact_value")
    private String contactValue;

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    @JsonBackReference
    private Person person;

    public Contact() {
    }

    public Contact(Integer contactId, Integer personId, String contactType, String contactValue) {
        this.contactId = contactId;
        this.personId = personId;
        this.contactType = contactType;
        this.contactValue = contactValue;
    }

    public Contact(Integer personId, String contactType, String contactValue) {
        this.personId = personId;
        this.contactType = contactType;
        this.contactValue = contactValue;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
