package dev.paie.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.ProfilRepository;

@Controller
public class InsererProfil implements Runnable {

	private ProfilRepository profilRepository;
	private CotisationRepository cotisationRepository;

	public InsererProfil(ProfilRepository profilRepository, CotisationRepository cotisationRepository) {
		super();
		this.profilRepository = profilRepository;
		this.cotisationRepository = cotisationRepository;
	}

	@Transactional
	public void run() {

		ProfilRemuneration profil = new ProfilRemuneration();

		profil.setCode("Assimilé cadre");

		List<Integer> listeCotisations = new ArrayList<>();

		Optional<ProfilRemuneration> profilCadre = this.profilRepository.findById(2);

		if (profilCadre.isPresent()) {
			List<Cotisation> listeCotisationsCadre = profilCadre.get().getCotisations();

			for (Cotisation cotis : listeCotisationsCadre) {
				// System.out.println(cotis.getId()+ " "+cotis.getCode());
				listeCotisations.add(cotis.getId());
			}
		}

		profil.setCotisations(this.cotisationRepository.findAllById(listeCotisations));
		this.profilRepository.save(profil);

	}

}
