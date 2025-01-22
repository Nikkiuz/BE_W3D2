package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	private String citta;

	@OneToMany(mappedBy = "location")
	private List<Evento> listaEventi = new ArrayList<>();

	public Location(){}

	public Location(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public List<Evento> getListaEventi() {
		return listaEventi;
	}

	public void setListaEventi(List<Evento> listaEventi) {
		this.listaEventi = listaEventi;
	}
}
