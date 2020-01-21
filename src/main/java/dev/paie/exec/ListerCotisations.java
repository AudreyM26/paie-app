package dev.paie.exec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.repository.CotisationRepository;

@Controller
public class ListerCotisations implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(ListerCotisations.class);

	private CotisationRepository cotisationRepository;

	public ListerCotisations(CotisationRepository cotisationRepository) {
		super();
		this.cotisationRepository = cotisationRepository;
	}

	@Override
	public void run() {
		this.cotisationRepository.findAll().forEach(cotisation -> {
			LOG.info("code {} libelle {} tauxSalarial {} tauxPatronal {} imosable{}", cotisation.getCode(),
					cotisation.getLibelle(), cotisation.getTauxSalarial(), cotisation.getTauxPatronal(),
					cotisation.getImposable());
		});

	}

}
