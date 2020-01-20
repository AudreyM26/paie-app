package dev.paie.exec;

import org.springframework.stereotype.Controller;

import dev.paie.entite.*;
import dev.paie.repository.*;

@Controller
public class InsererRemuneration implements Runnable {

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
		
		RemunerationEmploye employe = new RemunerationEmploye();
		employe.setMatricule("M01");
		
		employe.setGrade(this.gradeRepository.findById(1).get());
		employe.setEntreprise(this.entrepriseRepository.findById(3).get());
		employe.setProfilRemuneration(this.profilRepository.findById(2).get());
		this.employeRepository.save(employe);
	}

}
