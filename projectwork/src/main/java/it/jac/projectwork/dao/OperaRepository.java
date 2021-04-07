package it.jac.projectwork.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.projectwork.entity.Opera;

@Repository
public interface OperaRepository extends CrudRepository<Opera, Integer>{

}
