package dev.paie.exec;

import java.math.BigDecimal;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.EmployeRepository;
import dev.paie.repository.PeriodeRepository;

@Controller
public class InsererBulletin implements Runnable {

	private static final Logger LOG = LoggerFactory.getLogger(InsererBulletin.class);

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

		try {
			Periode period = this.periodeRepository.findById(12)
					.orElseThrow(() -> new EntityNotFoundException("Période non trouvée"));

			RemunerationEmploye remEmploye = this.employeRepository.findById(1)
					.orElseThrow(() -> new EntityNotFoundException("Rémunération employé non trouvée"));

			BulletinSalaire bulletin = new BulletinSalaire();
			bulletin.setPeriode(period);
			bulletin.setRemunerationEmploye(remEmploye);
			bulletin.setPrimeExceptionnelle(new BigDecimal("250.35"));

			this.bulletinRepository.save(bulletin);
			LOG.info("Bulletin inséré");

		} catch (EntityNotFoundException e) {
			LOG.error("Problème d accès à une donnée: " + e.getMessage());
		}

	}

}
