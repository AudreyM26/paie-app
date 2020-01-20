package dev.paie.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROFIL_REMUNERATION")
public class ProfilRemuneration {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="CODE")
	private String code;

	@ManyToMany
	@JoinTable(name="PROFIL_REMUNERATION_COTISATIONS",
			joinColumns=@JoinColumn(name="PROFIL_REMUNERATION_ID",referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="COTISATIONS_ID",referencedColumnName="ID")
	)
	private List<Cotisation> cotisations;

	@ManyToMany
	@JoinTable(name="PROFIL_REMUNERATION_AVANTAGE",
			joinColumns=@JoinColumn(name="PROFIL_REMUNERATION_ID",referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="AVANTAGE_ID",referencedColumnName="ID")
	)
	private List<Avantage> avantages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}


	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}
}
