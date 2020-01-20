package dev.paie.exec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Cotisation;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.*;

@Controller
public class InsererProfil implements Runnable {

	private ProfilRepository profilRepository;
	private CotisationRepository cotisationRepository;
	
	public InsererProfil(ProfilRepository profilRepository,CotisationRepository cotisationRepository) {
		super();
		this.profilRepository = profilRepository;
		this.cotisationRepository = cotisationRepository;
	}

	@Transactional
	public void run() {
		
		ProfilRemuneration profil = new ProfilRemuneration();

		profil.setCode("Assimilé cadre");
		
		List<Integer> listeCotisations = new ArrayList<>();
		
		ProfilRemuneration profilCadre = this.profilRepository.findById(2).get();
		List<Cotisation> listeCotisationsCadre = profilCadre.getCotisations();
		
		for(Cotisation cotis : listeCotisationsCadre){
			//System.out.println(cotis.getId()+ " "+cotis.getCode());
			listeCotisations.add(cotis.getId());
		}
		
		profil.setCotisations(this.cotisationRepository.findAllById(listeCotisations));
		this.profilRepository.save(profil);
		
	}

}
