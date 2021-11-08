package edu.supavenir.spanimals.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.supavenir.spanimals.entites.Espece;
import edu.supavenir.spanimals.entites.Race;
import edu.supavenir.spanimals.repositories.AnimalRepository;
import edu.supavenir.spanimals.repositories.EspeceRepository;
import edu.supavenir.spanimals.repositories.RaceRepository;
import io.github.jeemv.springboot.vuejs.VueJS;

@Controller
public class CaracteristiqueController {
	@GetMapping("/set")
	public String setCookie(HttpServletResponse response) {
		// set a new cookie
		// Cookie cookie = new Cookie(id, libelle,);
		// add cookie in server response
		// response.addCookie(cookie);

		return "Spring Boot Cookies";
	}

	@Autowired
	private VueJS vue;

	@ModelAttribute(name = "vue")
	private VueJS getVue() {
		return this.vue;
	}

	@Autowired
	private AnimalRepository aRepo;

	@Autowired
	private EspeceRepository eRepo;

	@Autowired
	private RaceRepository rRepo;

	@GetMapping("/search")
	public String indexRecherche(Model model) {
		vue.addDataRaw("dialog", "{visible: true}");
		vue.addData("search");
		List<Espece> especes = eRepo.findAll();
		vue.addData("especes", especes);
		vue.addData("valid", false);
		List<Race> races = rRepo.findAll();
		vue.addData("races", races);
		return "recherche";
	}

	@GetMapping("/tt")
	public @ResponseBody String tt() {
		return "tt";
	}

	@GetMapping("/Recherche/cookie")
	@ResponseBody
	public String updateCookie(@RequestParam Map<String, String> allParams) {
		return "Préférences de l'utilisateur : " + allParams.entrySet();
	}

	public void TestAnimalSimilaire(int caracteristique) {
		/*
		 * switch(caracteristique) {
		 * 
		 * case 1: "espece=={{espece}}"; break;
		 */
	}
}