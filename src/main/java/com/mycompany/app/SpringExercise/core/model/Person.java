package com.mycompany.app.SpringExercise.core.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="person")
public class Person{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id", columnDefinition = "serial")
    private Integer personId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="suffix")
    private String suffix;

    @Column(name="title")
    private String title;

    @Column(name="street_number")
    private Integer streetNumber;

    @Column(name="barangay")
    private String barangay;

    @Column(name="municipality_or_city")
    private String municipalityOrCity;

    @Column(name="zipcode")
    private Integer zipcode;

    @Column(name="birthday")
    private Date birthday;

    @Column(name="general_weighted_average")
    private Double generalWeightedAverage;

    @Column(name="date_hired")
    private Date dateHired;

    @Column(name="currently_employed")
    private String currentlyEmployed;

    public Person() {
    }

    public Person(Integer personId,
                  String firstName,
                  String lastName,
                  String middleName,
                  String suffix,
                  String title,
                  Integer streetNumber,
                  String barangay,
                  String municipalityOrCity,
                  Integer zipcode,
                  Date birthday,
                  Double generalWeightedAverage,
                  Date dateHired,
                  String currentlyEmployed) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.title = title;
        this.streetNumber = streetNumber;
        this.barangay = barangay;
        this.municipalityOrCity = municipalityOrCity;
        this.zipcode = zipcode;
        this.birthday = birthday;
        this.generalWeightedAverage = generalWeightedAverage;
        this.dateHired = dateHired;
        this.currentlyEmployed = currentlyEmployed;
    }

    public Person(String firstName,
                  String lastName,
                  String middleName,
                  String suffix,
                  String title,
                  Integer streetNumber,
                  String barangay,
                  String municipalityOrCity,
                  Integer zipcode,
                  Date birthday,
                  Double generalWeightedAverage,
                  Date dateHired,
                  String currentlyEmployed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.title = title;
        this.streetNumber = streetNumber;
        this.barangay = barangay;
        this.municipalityOrCity = municipalityOrCity;
        this.zipcode = zipcode;
        this.birthday = birthday;
        this.generalWeightedAverage = generalWeightedAverage;
        this.dateHired = dateHired;
        this.currentlyEmployed = currentlyEmployed;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getMunicipalityOrCity() {
        return municipalityOrCity;
    }

    public void setMunicipalityOrCity(String municipalityOrCity) {
        this.municipalityOrCity = municipalityOrCity;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getGeneralWeightedAverage() {
        return generalWeightedAverage;
    }

    public void setGeneralWeightedAverage(Double generalWeightedAverage) {
        this.generalWeightedAverage = generalWeightedAverage;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public String getCurrentlyEmployed() {
        return currentlyEmployed;
    }

    public void setCurrentlyEmployed(String currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", title='" + title + '\'' +
                ", streetNumber=" + streetNumber +
                ", barangay='" + barangay + '\'' +
                ", municipalityOrCity='" + municipalityOrCity + '\'' +
                ", zipcode=" + zipcode +
                ", birthday=" + birthday +
                ", generalWeightedAverage=" + generalWeightedAverage +
                ", dateHired=" + dateHired +
                ", currentlyEmployed='" + currentlyEmployed + '\'' +
                '}';
    }
}