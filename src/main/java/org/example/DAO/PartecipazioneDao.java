package org.example.DAO;

import org.example.Partecipazione;

import java.util.List;

public interface PartecipazioneDao {

	void save (Partecipazione partecipazione);

	Partecipazione findById (Long id);

	void deleteById (Long id);

	List<Partecipazione> findAll();
}