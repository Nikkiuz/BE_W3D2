package org.example;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;

	private String cognome;

	private String email;

	private LocalDate data_di_nascita;

	private String sesso;

	@OneToMany(mappedBy = "persona")
	private List<Partecipazione> lista_partecipazioni = new ArrayList<>();

	public Persona(){}

	public Persona(String nome, String cognome, String email, LocalDate data_di_nascita, String sesso) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.data_di_nascita = data_di_nascita;
		this.sesso = sesso;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getData_di_nascita() {
		return data_di_nascita;
	}

	public void setData_di_nascita(LocalDate data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public List<Partecipazione> getLista_partecipazioni() {
		return lista_partecipazioni;
	}

	public void setLista_partecipazioni(List<Partecipazione> lista_partecipazioni) {
		this.lista_partecipazioni = lista_partecipazioni;
	}

	public void addPartecipazioni(Partecipazione partecipazione){
		lista_partecipazioni.add(partecipazione);
	}
}
