package com.mycompany.app.SpringExercise.core.service;

import com.mycompany.app.SpringExercise.core.dao.PersonDao;
import com.mycompany.app.SpringExercise.core.model.Person;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("PersonService")
public class PersonServiceImpl implements PersonService{

    PersonDao personDao;

    @Override
    @Transactional
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        personDao.deletePerson(person);
    }
}
