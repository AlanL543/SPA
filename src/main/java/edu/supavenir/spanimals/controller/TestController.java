package edu.supavenir.spanimals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.supavenir.spanimals.entites.Animal;
import edu.supavenir.spanimals.entites.Espece;
import edu.supavenir.spanimals.entites.Refuge;
import edu.supavenir.spanimals.repositories.AnimalRepository;
import edu.supavenir.spanimals.repositories.EspeceRepository;
import edu.supavenir.spanimals.repositories.RefugeRepository;
import io.github.jeemv.springboot.vuejs.VueJS;

@Controller
public class TestController {

    @Autowired
    private VueJS vue;

    @ModelAttribute(name = "vue")
    private VueJS getVue() {
	return this.vue;
    }

    @Autowired
    private AnimalRepository repoAnimal;
    @Autowired
    private RefugeRepository repoRefuge;
    @Autowired
    private EspeceRepository repoEspece;

    @GetMapping("spanimals/add/animal")
    public @ResponseBody String addAnimal() {
	Animal medor = new Animal();
	medor.setNom("Medor");
	medor.setCouleur("Blanc/Marron");
	medor.setDescription("Gentil");
	if (repoAnimal.save(medor) != null) {
	    return medor + "Ajouté";
	}
	return "Problème d'ajout";
    }

    @GetMapping("spanimals/form")
    public String indexForm(Model model) {
	List<Refuge> refuges = repoRefuge.findAll();
	model.addAttribute("refuges", refuges);
	return "form";
    }

    @GetMapping("spanimals/listes")
    public String indexList(Model model) {
	List<Animal> animals = repoAnimal.findAll();
	model.addAttribute("animals", animals);
	return "listes";
    }

    @GetMapping("sos")
    public String listSosAction(Model model) {
	List<Animal> animals = repoAnimal.findBySos(true);
	model.addAttribute("animals", animals);
	return "sos";
    }

    @GetMapping("chiens")
    public String listChiensAction(Model model) {
	List<Animal> animals = repoAnimal.findByAdopte(true);
	model.addAttribute("animals", animals);
	return "adoptes";
    }

    @GetMapping("adoptes")
    public String listAdoptesAction(Model model) {
	Espece espece = repoEspece.findByLibelle("Chien");
	List<Animal> animals = repoAnimal.findByEspece(espece);
	model.addAttribute("animals", animals);
	return "chiens";
    }

}
