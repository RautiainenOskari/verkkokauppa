package com.projekti.verkkokauppa.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Valmistaja {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long valmistajaId;
	private String nimi;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "valmistaja")
	private List<Tuote> tuotteet;
	
	public Valmistaja() {}
	
	public Valmistaja(String nimi) {
		super();
		this.nimi = nimi;
	}

	public Long getValmistajaId() {
		return valmistajaId;
	}

	public void setValmistajaId(Long valmistajaId) {
		this.valmistajaId = valmistajaId;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Tuote> getTuotteet() {
		return tuotteet;
	}

	public void setTuotteet(List<Tuote> tuotteet) {
		this.tuotteet = tuotteet;
	}
	
	@Override
	public String toString() {
		return "Valmistaja [valmistajaId=" + valmistajaId + ", nimi=" + nimi + "]";
	}
}
