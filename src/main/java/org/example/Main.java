package org.example;
import org.example.DAO.EventoDao;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {

		EventoDao eventoDao = new EventoDaoImpl();
		Evento comicon = new Evento("Comicon",LocalDate.of(2025,10,13),
			"pubblico",1500,"Fiera del fumetto, gaming, film ecc. ecc.");

		eventoDao.save(comicon);
		System.out.println("Evento Salvato con ID " +comicon.getId());

		Evento eventoDaTrovare = eventoDao.findById(6L);
		if(eventoDaTrovare != null){
			System.out.println("Evento trovato: "+eventoDaTrovare.getTitolo());
		} else {
			System.out.println("Evento non trovato");
		}

		eventoDao.deleteById(6L);
		
	}

}