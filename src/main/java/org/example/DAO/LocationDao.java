package org.example.DAO;

import org.example.Location;

import java.util.List;

public interface LocationDao {
	void save (Location location);

	Location findById(long id);

	void deleteById(long id);

	List<Location> findAll();
}
