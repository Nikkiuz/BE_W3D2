package org.example;

import java.util.List;

public interface EventoDao {

	void save (Evento evento);

	Evento findById (Long id);

	void deletebById (Long id);

	List<Evento> findAll();
}
