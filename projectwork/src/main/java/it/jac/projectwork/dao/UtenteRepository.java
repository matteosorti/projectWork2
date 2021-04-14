package it.jac.projectwork.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.projectwork.entity.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Integer>{
	public Utente findByUsername(String username);
}
