package org.example.DAO;

import org.example.Persona;

import java.util.List;

public interface PersonaDao {

	void save (Persona persona);

	Persona findById(long id);

	void deleteById(long id);

	List<Persona> findAll();
}
