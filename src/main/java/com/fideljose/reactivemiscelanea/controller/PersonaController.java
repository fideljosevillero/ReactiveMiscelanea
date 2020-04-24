package com.fideljose.reactivemiscelanea.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class PersonaController {

	@GetMapping({"index", "/"})
	public String index(@RequestParam(required=false) String id, String name) {
		return "Respuesta" + " => ID " + id + " Name " + name + "!!!";
	}
	
}
