package it.jac.projectwork.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.projectwork.entity.Artista;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Integer>{

}
