package edu.supavenir.spanimals.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.supavenir.spanimals.entites.Refuge;
import edu.supavenir.spanimals.repositories.RefugeRepository;

@Controller
public class RefugeController {

	@Autowired
	private RefugeRepository repoRefuge;
	
	@GetMapping("refuge/{id}")
	public String index(@PathVariable int id,Model model) {
		Optional<Refuge> optRefuge=repoRefuge.findById(id);
		Refuge refuge=null;
		if(optRefuge.isPresent()) {
			refuge=optRefuge.get();
		}
		model.addAttribute("refuge",refuge);
		return "FicheRefuge";
	}
}
