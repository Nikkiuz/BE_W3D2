package org.example;
import org.example.DAO.EventoDao;
import org.example.DAO.PartecipazioneDao;
import org.example.DAO.PersonaDao;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {

		EventoDao eventoDao = new EventoDaoImpl();
		Evento comicon = new Evento("Comicon",LocalDate.of(2025,10,13),
			"pubblico",1500,"Fiera del fumetto, gaming, film ecc. ecc.");

		//eventoDao.save(comicon);
		//System.out.println("Evento Salvato con ID: " +comicon.getId());

		PersonaDao personaDao = new PersonaDaoImpl();
		Persona niccolo = new Persona("niccolò","albanese","niccoalba@pippo.it",
			LocalDate.of(1990,07,24),"m");

		//personaDao.save(niccolo);
		//System.out.println("Persona salvata con ID: "+niccolo.getId());


		PartecipazioneDao partecipazioneDao = new PartecipazioneDaoImpl();
		Partecipazione partecipazioneComicon = new Partecipazione(niccolo,comicon,"da_confermare");

		//PartecipazioneDao.save(partecipazioneComicon);
		System.out.println("Partecipazione salvata");

		/*Evento eventoDaTrovare = eventoDao.findById(6L);
		if(eventoDaTrovare != null){
			System.out.println("Evento trovato: "+eventoDaTrovare.getTitolo());
		} else {
			System.out.println("Evento non trovato");
		}

		eventoDao.deleteById(6L);*/

	}

}