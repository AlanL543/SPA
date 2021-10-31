package edu.supavenir.spanimals.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CaracteristiqueController {
	@GetMapping("/set")
	public String setCookie(HttpServletResponse response) {
	    // set a new cookie
	    Cookie cookie = new Cookie(id, libelle,);
	    // add cookie in server response
	    response.addCookie(cookie);

	    return "Spring Boot Cookies";
	}
public void TestAnimalSimilaire(int caracteristique)  {
	switch(caracteristique) {
	
	case 1:
		"espece=={{espece}}";
		break;
	}
}
}