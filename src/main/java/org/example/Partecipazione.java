package org.example;

import jakarta.persistence.*;

@Entity
public class Partecipazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name="persona_id", nullable = false)
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	private String stato;

	public Partecipazione(){}

	public Partecipazione(Persona persona, Evento evento, String stato) {
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	public long getId() {
		return id;
	}


	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
}
