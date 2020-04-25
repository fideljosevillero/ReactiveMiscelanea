package com.fideljose.reactivemiscelanea.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fideljose.reactivemiscelanea.Person;

@RestController()
@RequestMapping("/api")
public class PersonController {

	@GetMapping(value={"index", "/"})
	public String index(@RequestParam(required=false) String id, String name) {
		return "Respuesta" + " => ID " + id + " Name " + name + "!!!";
	}
	
	@GetMapping(value={"responsexml"})
	public Person responseXML(@RequestParam(required=false) String id, String name) {
		return new Person("fidel", "Villero", "fidel@fidel.com", "COLOMBIA");
	}
	
	@PostMapping("/save")
	public Person saveTempPerson(@Valid @RequestBody Person person) {
		String UID = UUID.randomUUID().toString();
		person.setId(UID);
		return person;
	}
	
}
