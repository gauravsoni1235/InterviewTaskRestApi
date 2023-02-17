package com.example.person.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepo;

@Service	
public class PersonService {
	
	    @Autowired
	    private PersonRepo personRepository;

	    public List<Person> getAllPersons() {
	        return personRepository.findAll();
	    }

	    public Person getPersonById(int id) {
	        return personRepository.findById(id).orElse(null);
	    }

	    public Person addPerson(Person person) {
	        return personRepository.save(person);
	    }

	    public Person updatePerson(int id, Person person) {
	        Person existingPerson = personRepository.findById(id).orElse(null);
	        if (existingPerson != null) {
	            existingPerson.setFirstName(person.getFirstName());
	            existingPerson.setLastName(person.getLastName());
	            existingPerson.setEmail(person.getEmail());
	            existingPerson.setAge(person.getAge());
	            return personRepository.save(existingPerson);
	        }
	        return null;
	    }

	    public void deletePerson(int id) {
	        personRepository.deleteById(id);
	    }
	}
