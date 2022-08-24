package ru.filatov.spring.springApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.filatov.spring.springApp.models.Person;
import ru.filatov.spring.springApp.repositories.PeopleRepository;
import ru.filatov.spring.springApp.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUserName(username);

        if(person.isEmpty()){
            throw new UsernameNotFoundException("User not found!");
        }

        return new PersonDetails(person.get());
    }
}
