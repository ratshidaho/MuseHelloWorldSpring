package org.muse.resource;

import org.muse.entities.Person;
import org.muse.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TestResource {

    private final PersonRepository personRepository;

    public TestResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping("/")
    public String helloWord() {
        return "<html>" +
                "<label>Name:</label>" +
                "<input type=text>" +
                "<br>"+
                "<input type=submit>"+
                "</html>";
    }

    @RequestMapping("/again")
    public String helloWorld2() {
        return "Hello Again";
    }

    @RequestMapping("/savePerson")
    public Person savePerson(@RequestParam String name, @RequestParam String surname, @RequestParam Integer age) {
        Person person = new Person();
        person.setId(UUID.randomUUID().toString());

        person.setName(name);
        person.setSurname(surname);
        person.setAge(age);
        return personRepository.save(person);
    }

    @RequestMapping("/all")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
