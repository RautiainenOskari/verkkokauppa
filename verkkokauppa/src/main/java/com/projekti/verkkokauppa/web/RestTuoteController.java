package com.projekti.verkkokauppa.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projekti.verkkokauppa.domain.Tuote;
import com.projekti.verkkokauppa.domain.TuoteRepository;
import com.projekti.verkkokauppa.domain.Valmistaja;
import com.projekti.verkkokauppa.domain.ValmistajaRepository;

@RestController
public class RestTuoteController {

	@Autowired
	private TuoteRepository trepository;
	@Autowired
	private ValmistajaRepository vrepository;

	// Listaa tuotteet
	@RequestMapping(value = "/tuotteet", method = RequestMethod.GET)
	public @ResponseBody List<Tuote> tuoteListaRest() {
		return (List<Tuote>) trepository.findAll();
	}

	// Löytää tuotteen id:n avulla
	@RequestMapping(value = "/tuote/{id}", method = RequestMethod.GET)
	public @ResponseBody Tuote findTuoteRest(@PathVariable("id") Long id) {
		Optional<Tuote> tuoteOptional = trepository.findById(id);
		return tuoteOptional.orElse(null);
	}

	//Listaa valmistajat
	@RequestMapping(value = "/valmistajatRest", method = RequestMethod.GET)
	public @ResponseBody List<Valmistaja> valmistajaListaRest() {
		return (List<Valmistaja>) vrepository.findAll();
	}

	//Löytää valmistajan id:n avulla
	@RequestMapping(value = "/valmistaja/{id}", method = RequestMethod.GET)
	public @ResponseBody Valmistaja findValmistajaRest(@PathVariable("id") Long valmistajaId) {
		Optional<Valmistaja> valmistajaOptional = vrepository.findById(valmistajaId);
		return valmistajaOptional.orElse(null);
	}
}
