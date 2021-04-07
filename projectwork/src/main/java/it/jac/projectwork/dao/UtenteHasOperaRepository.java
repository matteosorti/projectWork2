package it.jac.projectwork.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.projectwork.entity.UtenteHasOpera;

@Repository
public interface UtenteHasOperaRepository extends CrudRepository<UtenteHasOpera, Integer>{

}
