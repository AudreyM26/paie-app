package dev.paie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dev.paie.exec.*;

@SpringBootApplication
@EnableTransactionManagement
public class PaieAppApplication {
	public static void main(String[] args) {
		// Récupération du contexte Spring créé par Spring Boot
		// La classe de configuration initiale de Spring est PaieAppApplication
		ConfigurableApplicationContext context = SpringApplication.run(PaieAppApplication.class, args);
		// Récupération d'un bean de type Runnable
		//Runnable exec = context.getBean(Runnable.class);
		
		//afficher les cotisations
		//Runnable exec = context.getBean(ListerCotisations.class);
		//inserer un grade
		//Runnable exec = context.getBean(InsererGrade.class);
		//inserer un profil
		//Runnable exec = context.getBean(InsererProfil.class);
		//inserer une remuneration
		//Runnable exec = context.getBean(InsererRemuneration.class);
		
		//inserer un bulletin
		Runnable exec = context.getBean(InsererBulletin.class);
		// exécution
		exec.run();
	}
}