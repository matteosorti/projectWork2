package it.jac.projectwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "utente_has_opera")
@Data
public class UtenteHasOpera {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "id_utente")
	private int idutente;
	
	
	@Column(name = "id_opera")
	private int idopera;
	
	@Column(name = "valore")
	private int valore;
}
