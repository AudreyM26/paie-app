package dev.paie.exec;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

@Controller
public class InsererGrade implements Runnable {

	private GradeRepository gradeRepository;
	
	public InsererGrade(GradeRepository gradeRepository) {
		super();
		this.gradeRepository = gradeRepository;
	}

	@Override
	public void run() {
		
		Grade grade= new Grade();
		grade.setCode("GRADE_D");
		grade.setNbHeuresBase(new BigDecimal(150));
		grade.setTauxBase(new BigDecimal(15.00));
		this.gradeRepository.save(grade);
	}

}
