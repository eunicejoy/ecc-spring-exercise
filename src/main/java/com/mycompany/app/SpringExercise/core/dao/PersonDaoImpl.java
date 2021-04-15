package com.mycompany.app.SpringExercise.core.dao;


import com.mycompany.app.SpringExercise.core.model.Person;
import org.hibernate.SessionFactory;

public class PersonDaoImpl implements PersonDao {

    private SessionFactory sessionFactory;
    @Override
    public void addPerson(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public void updatePerson(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    public void deletePerson(Person person) {
        sessionFactory.getCurrentSession().delete(person);
    }
}
