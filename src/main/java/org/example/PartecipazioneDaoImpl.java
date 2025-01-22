package org.example;

import org.example.DAO.PartecipazioneDao;

import jakarta.persistence.EntityManager;

import java.util.List;

public class PartecipazioneDaoImpl implements PartecipazioneDao{
	@Override
	public void save(Partecipazione partecipazione) {
		EntityManager entity = EntityManagerUtil.getEntityManager();

		try{
			entity.getTransaction().begin();
			entity.persist(partecipazione);
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
	public Partecipazione findById(Long id) {
		EntityManager entity = EntityManagerUtil.getEntityManager();
		try{
			entity.getTransaction().begin();
			Partecipazione partecipazioneTrovata = entity.find(Partecipazione.class, id);
			entity.getTransaction().commit();
			return partecipazioneTrovata;

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
			Partecipazione partecipazione = findById(id);
			if(partecipazione != null){
				entity.remove(partecipazione);
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
	public List<Partecipazione> findAll() {
		EntityManager entity = EntityManagerUtil.getEntityManager();

		try {
			return entity.createQuery("SELECT * FROM evento", Partecipazione.class).getResultList();

		} finally {
			entity.close();
			;
		}
	}
}
