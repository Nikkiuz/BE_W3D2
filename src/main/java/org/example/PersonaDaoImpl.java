package org.example;
import org.example.DAO.PersonaDao;

import jakarta.persistence.EntityManager;

import java.util.List;

public class PersonaDaoImpl implements PersonaDao {

	@Override
	public void save(Persona persona) {
		EntityManager entity = EntityManagerUtil.getEntityManager();

		try{
			entity.getTransaction().begin();
			entity.persist(persona);
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
	public Persona findById(long id) {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		try{
			entity.getTransaction().begin();
			Persona personaTrovata = entity.find(Persona.class, id);
			entity.getTransaction().commit();
			return personaTrovata;

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
			Persona persona = findById(id);
			if(persona != null){
				entity.remove(persona);
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
	public List<Persona> findAll() {
		EntityManager entity = EntityManagerUtil.getEntityManager();

		try {
			return entity.createQuery("SELECT * FROM evento", Persona.class).getResultList();

		} finally {
			entity.close();
			;
		}
	}
}