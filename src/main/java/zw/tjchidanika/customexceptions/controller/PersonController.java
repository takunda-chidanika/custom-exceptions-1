package zw.tjchidanika.customexceptions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.tjchidanika.customexceptions.dto.PersonDto;
import zw.tjchidanika.customexceptions.model.Person;
import zw.tjchidanika.customexceptions.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person/")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody PersonDto personDto){
        return new ResponseEntity<>(personService.save(personDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Person>> findAll(){
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> find(@PathVariable String id){
        return new ResponseEntity<>(personService.find(id), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Person> update(@RequestBody Person person){
        return new ResponseEntity<>(personService.update(person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        return new ResponseEntity<>(personService.delete(id), HttpStatus.OK);
    }
}
