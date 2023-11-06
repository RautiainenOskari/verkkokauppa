package com.projekti.verkkokauppa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projekti.verkkokauppa.domain.TuoteRepository;
import com.projekti.verkkokauppa.domain.ValmistajaRepository;
import com.projekti.verkkokauppa.domain.Tuote;

@Controller
public class TuoteController {
	@Autowired
	private TuoteRepository repository;
	@Autowired
	private ValmistajaRepository vRepository;
	
	@RequestMapping("/tuotelista")
	public String tuoteLista(Model model) {
		model.addAttribute("Tuotteet", repository.findAll());
		return "tuotelistat";
		
	}
	
}
