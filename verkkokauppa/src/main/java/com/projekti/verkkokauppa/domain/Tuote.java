package com.projekti.verkkokauppa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tuote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nimi, vari;
	
	@ManyToOne
	@JoinColumn(name = "valmistajaId")
	private Valmistaja valmistaja;
	private Integer Julkaisupaivamaara;
	private Double hinta;
	
	public Tuote() {}
	
	public Tuote(String nimi, String vari, Valmistaja valmistaja, Integer julkaisupaivamaara, Double hinta) {
		super();
		this.nimi = nimi;
		this.vari = vari;
		this.valmistaja = valmistaja;
		Julkaisupaivamaara = julkaisupaivamaara;
		this.hinta = hinta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getVari() {
		return vari;
	}

	public void setVari(String vari) {
		this.vari = vari;
	}

	public Valmistaja getValmistaja() {
		return valmistaja;
	}

	public void setValmistaja(Valmistaja valmistaja) {
		this.valmistaja = valmistaja;
	}

	public Integer getJulkaisupaivamaara() {
		return Julkaisupaivamaara;
	}

	public void setJulkaisupaivamaara(Integer julkaisupaivamaara) {
		Julkaisupaivamaara = julkaisupaivamaara;
	}

	public Double getHinta() {
		return hinta;
	}

	public void setHinta(Double hinta) {
		this.hinta = hinta;
	}
}
