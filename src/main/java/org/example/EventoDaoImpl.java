package org.example;
import org.example.DAO.EventoDao;

import jakarta.persistence.EntityManager;

import java.util.List;

public class EventoDaoImpl implements EventoDao {

	@Override
	public void save(Evento evento) {
		EntityManager entity = EntityManagerUtil.getEntityManager();

		try{
			entity.getTransaction().begin();
			entity.persist(evento);
			entity.getTransaction().commit();

		} catch (Exception e){
			if (entity.getTransaction().isActive())
				entity.getTransaction().rollback();
		}
		finally {
			entity.close();
		}
	}

	@Override
	public Evento findById(Long id) {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		try{
			entity.getTransaction().begin();
			Evento eventoTrovato = entity.find(Evento.class, id);
			entity.getTransaction().commit();
			return eventoTrovato;

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
	public void deleteById(Long id) {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		try{
			entity.getTransaction().begin();
			//Evento evento = findById(id);
			Evento evento = entity.find(Evento.class, id);
			if(evento != null){
				entity.remove(evento);
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
	public List<Evento> findAll() {
		EntityManager entity = EntityManagerUtil.getEntityManager();

		try{
			return entity.createQuery("SELECT * FROM evento", Evento.class).getResultList();

		} finally {
			entity.close();

		}
	}
}
