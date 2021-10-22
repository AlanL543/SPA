package edu.supavenir.spanimals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.supavenir.spanimals.entites.Animal;
import edu.supavenir.spanimals.entites.Refuge;
import edu.supavenir.spanimals.repositories.AnimalRepository;
import edu.supavenir.spanimals.repositories.RefugeRepository;

@RestController
public class TestRestController {

    @Autowired
    private AnimalRepository repoAnimal;

    @GetMapping("/rest/animals")
    public List<Animal> indexAction() {
	return repoAnimal.findAll();
    }

    @Autowired
    private RefugeRepository repoRefuge;

    @GetMapping("/rest/refuges")
    public List<Refuge> indexxAction() {
	return repoRefuge.findAll();
    }

}
