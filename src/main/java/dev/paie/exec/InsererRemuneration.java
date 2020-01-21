package dev.paie.exec;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EmployeRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;

@Controller
public class InsererRemuneration implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(InsererRemuneration.class);

	private EmployeRepository employeRepository;
	private GradeRepository gradeRepository;
	private EntrepriseRepository entrepriseRepository;
	private ProfilRepository profilRepository;

	public InsererRemuneration(EmployeRepository employeRepository, GradeRepository gradeRepository,
			EntrepriseRepository entrepriseRepository, ProfilRepository profilRepository) {
		super();
		this.employeRepository = employeRepository;
		this.gradeRepository = gradeRepository;
		this.entrepriseRepository = entrepriseRepository;
		this.profilRepository = profilRepository;
	}

	@Override
	public void run() {

		try {

			Grade grade = this.gradeRepository.findById(4)
					.orElseThrow(() -> new EntityNotFoundException("Grade non trouvé"));

			Entreprise entreprise = this.entrepriseRepository.findById(3)
					.orElseThrow(() -> new EntityNotFoundException("Entreprise non trouvée"));

			ProfilRemuneration profil = this.profilRepository.findById(2)
					.orElseThrow(() -> new EntityNotFoundException("Profil non trouvé"));

			RemunerationEmploye employe = new RemunerationEmploye();
			employe.setMatricule("M01");
			employe.setGrade(grade);
			employe.setEntreprise(entreprise);
			employe.setProfilRemuneration(profil);
			this.employeRepository.save(employe);

			LOG.info("Rémunération insérée");

		} catch (EntityNotFoundException e) {
			LOG.error("Problème d accès à une donnée: " + e.getMessage());
		}
	}

}
