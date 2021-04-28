package it.jac.projectwork.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "opera")
@Data
public class Opera {
	@Id
	@Column(name = "idopera")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idopera;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "tipologia")
	private String tipologia;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "foto")
	private String foto;
	
	@Column(name = "idartista")
	private int idartista;
	
	@Column(name = "valore")
	private double valore;
	
	@Column(name = "creazione")
	private Date creazione;
	
	@Column(name = "scadenza")
	private Date scadenza;
	
	@Column(name = "scaduto")
	private int scaduto;
}
