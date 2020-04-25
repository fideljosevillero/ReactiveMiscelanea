package com.fideljose.reactivemiscelanea.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value={"responsexml"})//,
//			consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = MediaType.APPLICATION_XML_VALUE)
	public Person responseXML(@RequestParam(required=false) String id, String name) {
		return new Person("fidel", "Villero", "fidel@fidel.com", "COLOMBIA");
	}
	
}
