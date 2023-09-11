package zw.tjchidanika.customexceptions.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zw.tjchidanika.customexceptions.dto.PersonDto;
import zw.tjchidanika.customexceptions.exception.PersonNotFoundException;
import zw.tjchidanika.customexceptions.model.Person;
import zw.tjchidanika.customexceptions.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {
    private final PersonRepository personRepository;
    public Person save(PersonDto record){
        var person = Person.builder()
                .firstname(record.firstname())
                .middlename(record.middlename())
                .lastname(record.lastname())
                .nationality(record.nationality())
                .gender(record.gender())
                .dob(record.dob())
                .contacts(record.contact())
                .build();
        return personRepository.save(person);
    }

    public Person find(String id){
        return personRepository.findById(id).orElseThrow(
                ()-> new PersonNotFoundException("Person Not Found")
        );
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public String delete(String id){
        Person exist = personRepository.findById(id).orElseThrow(
                ()-> new PersonNotFoundException("Person Not Found")
        );
        personRepository.delete(exist);

        return "Person Deleted Successfully";
    }

    public Person update(Person person){
       Person exist = personRepository.findById(person.getId()).orElseThrow(
               ()-> new PersonNotFoundException("Person Not Found")
       );

       if(person.getFirstname() !=null && !person.getFirstname().equals(exist.getFirstname())){
           exist.setFirstname(person.getFirstname());
       }

        if(person.getMiddlename() !=null && !person.getMiddlename().equals(exist.getMiddlename())){
            exist.setMiddlename(person.getMiddlename());
        }

        if(person.getLastname() !=null && !person.getLastname().equals(exist.getLastname())){
            exist.setLastname(person.getLastname());
        }

        if(person.getGender() !=null && !person.getGender().equals(exist.getGender())){
            exist.setGender(person.getGender());
        }

        if(person.getNationality() !=null && !person.getNationality().equals(exist.getNationality())){
            exist.setNationality(person.getNationality());
        }
        if(person.getDob() !=null && !person.getDob().equals(exist.getDob())){
            exist.setDob(person.getDob());
        }

       return personRepository.save(exist);
    }
}
