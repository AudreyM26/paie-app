package dev.paie.exec;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.*;

@Controller
public class InsererBulletin implements Runnable {

	private BulletinRepository bulletinRepository;
	private PeriodeRepository periodeRepository;
	private EmployeRepository employeRepository;
	
	
	public InsererBulletin(BulletinRepository bulletinRepository, PeriodeRepository periodeRepository,
			EmployeRepository employeRepository) {
		super();
		this.bulletinRepository = bulletinRepository;
		this.periodeRepository = periodeRepository;
		this.employeRepository = employeRepository;
	}


	@Override
	public void run() {
		
		BulletinSalaire bulletin = new BulletinSalaire();
		bulletin.setPeriode(this.periodeRepository.findById(11).get());
		bulletin.setRemunerationEmploye(this.employeRepository.findById(1).get());
		bulletin.setPrimeExceptionnelle(new BigDecimal("100"));
		
		this.bulletinRepository.save(bulletin);
	}

}
