package edu.supavenir.spanimals.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.supavenir.spanimals.entites.Animal;
import edu.supavenir.spanimals.repositories.AnimalRepository;

@Controller
public class AnimalController {

	@Autowired
	private AnimalRepository repoAnimal;
	
	@GetMapping("animal/{id}")
	public String index(@PathVariable int id, Model model) {
		Optional<Animal> optAnimal=repoAnimal.findById(id);
		Animal animal=null;
		if(optAnimal.isPresent()) {
			animal=optAnimal.get();
		}
		model.addAttribute("animal",animal);
		return "FicheAnimal";
	}
	}

