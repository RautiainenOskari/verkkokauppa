package com.projekti.verkkokauppa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Tuote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String nimi, vari;
	

	@ManyToOne
	@JoinColumn(name = "valmistajaId")
	private Valmistaja valmistaja;

	@NotNull
	
	private Integer Julkaisupaivamaara;
	@NotNull
	
	private Double hinta;
	
	private String kuva;
	
	public Tuote() {}
	
	public Tuote(String nimi, String vari, Valmistaja valmistaja, Integer julkaisupaivamaara, Double hinta, String kuva) {
		super();
		this.nimi = nimi;
		this.vari = vari;
		this.valmistaja = valmistaja;
		Julkaisupaivamaara = julkaisupaivamaara;
		this.hinta = hinta;
		this.kuva = kuva;
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
	
	@Override
	public String toString() {
		return "Tuote [id=" + id + ", nimi=" + nimi + ", vari=" + vari + ", valmistaja=" + valmistaja
				+ ", julkaisuaika=" + Julkaisupaivamaara + ", hinta=" + hinta + "]";
	}

	@Lob
	@Column(name = "Kuva", length = Integer.MAX_VALUE, nullable = true)
	public String getKuva() {
		return kuva;
	}

	public void setKuva(String kuva) {
		this.kuva = kuva;
	}
	
}
