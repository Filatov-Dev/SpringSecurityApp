package ru.filatov.spring.springApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.filatov.spring.springApp.models.Person;
import ru.filatov.spring.springApp.repositories.PeopleRepository;

import javax.transaction.Transactional;

@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    @Transactional
    public void register(Person person){
        peopleRepository.save(person);
    }
}
