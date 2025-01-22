package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Evento")

public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "titolo")
	private String titolo;

	@Column(name = "data_evento")
	private LocalDate data_evento;


	@Column(name = "tipo_evento")
	private String tipo_evento;

	@Column(name = "numero_max_partecipanti")
	private int numero_max_partecipanti;

	@Column(name = "descrizione")
	private String descrizione;

	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;


	public Evento() {
	}

	public Evento(String titolo, LocalDate data_evento, String tipo_evento, int numero_max_partecipanti,
	              String descrizione) {
		this.titolo = titolo;
		this.data_evento = data_evento;
		this.tipo_evento = tipo_evento;
		this.numero_max_partecipanti = numero_max_partecipanti;
		this.descrizione = descrizione;
	}

	public Evento(String titolo, LocalDate data_evento, String tipo_evento, int numero_max_partecipanti, String descrizione,
	              Location location) {
		this.titolo = titolo;
		this.data_evento = data_evento;
		this.tipo_evento = tipo_evento;
		this.numero_max_partecipanti = numero_max_partecipanti;
		this.descrizione = descrizione;
		this.location = location;
	}

	public long getId() {
		return this.id;
	}


	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public LocalDate getData_evento() {
		return data_evento;
	}

	public void setData_evento(LocalDate data_evento) {
		this.data_evento = data_evento;
	}


	public String getTipo_evento() {
		return tipo_evento;
	}

	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}


	public int getNumero_max_partecipanti() {
		return numero_max_partecipanti;
	}

	public void setNumero_max_partecipanti(int numero_max_partecipanti) {
		this.numero_max_partecipanti = numero_max_partecipanti;
	}


	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
