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
			
			Tuote t1 = new Tuote("Iphone 15", "Musta", vrepository.findByNimi("Apple").get(0), 2023, 999.99);
			
			User u1 = new User("admin", "$2a$12$uv0pjvLc.L/mr.nisKDOO.AavxHOR7dWz1AjydS2Eya83Ivryc1ce", "ADMIN");
			
			trepository.save(t1);
			urepository.save(u1);
		};
		
	}

}
