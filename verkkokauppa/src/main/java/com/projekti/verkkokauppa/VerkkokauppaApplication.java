package com.projekti.verkkokauppa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.projekti.verkkokauppa.domain.Tuote;
import com.projekti.verkkokauppa.domain.TuoteRepository;
import com.projekti.verkkokauppa.domain.User;
import com.projekti.verkkokauppa.domain.UserRepository;
import com.projekti.verkkokauppa.domain.Valmistaja;
import com.projekti.verkkokauppa.domain.ValmistajaRepository;

@SpringBootApplication
public class VerkkokauppaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerkkokauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner verkkokauppaDemo(TuoteRepository trepository, ValmistajaRepository vrepository, UserRepository urepository) {
		return (args) -> {
			
			vrepository.save(new Valmistaja("Apple"));
			vrepository.save(new Valmistaja("Samsung"));
			vrepository.save(new Valmistaja("Asus"));
			vrepository.save(new Valmistaja("HP"));
			vrepository.save(new Valmistaja("Sony"));
			
			Tuote t1 = new Tuote("Iphone 15", "Musta", vrepository.findByNimi("Apple").get(0), 2023, 999.99, "/kuvat/iphone-15-pro-finish-select-202309-6-7inch-naturaltitanium.jpg");
			Tuote t2 = new Tuote("Playstation 5", "Valkoinen", vrepository.findByNimi("Sony").get(0), 2020, 550.95, "/kuvat/ps5.jpg");
			Tuote t3 = new Tuote("HP Omen 30L", "Musta", vrepository.findByNimi("HP").get(0), 2021, 2600.00, "/kuvat/gamingpc.jpg");
			Tuote t4 = new Tuote("Sony Walkman", "Sininen", vrepository.findByNimi("Sony").get(0), 1979, 80.00, "/kuvat/walkman.jpg");
			Tuote t5 = new Tuote("Asus ROG STRIX G16", "Musta", vrepository.findByNimi("Asus").get(0), 2022, 3299.99, "/kuvat/asuspc.jpg");
			Tuote t6 = new Tuote("Macbook Pro", "Hopea", vrepository.findByNimi("Apple").get(0), 2023, 1599.99, "/kuvat/mcbook.jpg");
			
			User u1 = new User("admin", "$2a$12$uv0pjvLc.L/mr.nisKDOO.AavxHOR7dWz1AjydS2Eya83Ivryc1ce", "ADMIN");
			User u2 = new User("kayttaja", "$2a$12$uv0pjvLc.L/mr.nisKDOO.AavxHOR7dWz1AjydS2Eya83Ivryc1ce", "USER");
			
			trepository.save(t1);
			trepository.save(t2);
			trepository.save(t3);
			trepository.save(t4);
			trepository.save(t5);
			trepository.save(t6);
			urepository.save(u1);
			urepository.save(u2);
		};
		
	}

}
