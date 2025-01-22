package org.example;

import org.example.DAO.LocationDao;

import jakarta.persistence.EntityManager;

import java.util.List;

public class LocationDaoImpl implements LocationDao {

	@Override
	public void save(Location location) {
		EntityManager entity = EntityManagerUtil.getEntityManager();

		try{
			entity.getTransaction().begin();
			entity.persist(location);
			entity.getTransaction().commit();

		} catch (Exception e) {
			if (entity.getTransaction().isActive())
				entity.getTransaction().rollback();
		}
		finally {
			entity.close();
		}
	}

	@Override
	public Location findById(long id) {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		try{
			entity.getTransaction().begin();
			Location locationTrovata = entity.find(Location.class, id);
			entity.getTransaction().commit();
			return locationTrovata;

		} catch(Exception e) {
			if(entity.getTransaction().isActive())
				entity.getTransaction().rollback();
			e.printStackTrace();
			return null;

		}
		finally{
			entity.close();
		}

	}

	@Override
	public void deleteById(long id) {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		try{
			entity.getTransaction().begin();
			Location location = findById(id);
			if(location != null){
				entity.remove(location);
				entity.getTransaction().commit();
			}

		} catch(Exception e){
			if(entity.getTransaction().isActive())
				entity.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			entity.close();
		}
	}

	@Override
	public List<Location> findAll() {
		EntityManager entity = EntityManagerUtil.getEntityManager();

		try {
			return entity.createQuery("SELECT * FROM evento", Location.class).getResultList();

		} finally {
			entity.close();
			;
		}
	}
}
