package it.jac.projectwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "utente")
@Data

public class Utente {
	@Id
	@Column(name = "idutente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idutente;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

}





	