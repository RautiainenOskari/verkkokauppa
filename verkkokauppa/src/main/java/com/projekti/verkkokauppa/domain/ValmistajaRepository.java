package com.projekti.verkkokauppa.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValmistajaRepository extends CrudRepository<Valmistaja, Long> {

	List<Valmistaja> findByNimi(String nimi);
	
}
