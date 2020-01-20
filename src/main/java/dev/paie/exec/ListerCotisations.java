package dev.paie.exec;

import org.springframework.stereotype.Controller;

import dev.paie.repository.CotisationRepository;

@Controller
public class ListerCotisations  implements Runnable {

	private CotisationRepository cotisationRepository;

	public ListerCotisations(CotisationRepository cotisationRepository) {
		super();
		this.cotisationRepository = cotisationRepository;
	}
	
	@Override
	public void run() {
		this.cotisationRepository.findAll().forEach(cotisation-> {
        	System.out.println(cotisation);
        });
		
	}

}
