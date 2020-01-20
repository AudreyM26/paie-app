package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="COTISATION")
public class Cotisation {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="LIBELLE")
	private String libelle;
	
	@Column(name="TAUX_SALARIAL")
	private BigDecimal tauxSalarial;
	
	@Column(name="TAUX_PATRONAL")
	private BigDecimal tauxPatronal;
	
	@Column(name="IMPOSABLE")
	private Boolean imposable = false;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getImposable() {
		return imposable;
	}
	public void setImposable(Boolean imposable) {
		this.imposable = imposable;
	}
	
	public String toString() {
		
		String text = this.getId()+" - "+this.getCode()+" - "+this.getLibelle() +" imposable : "+this.getImposable()+" - taux patronal : "+this.getTauxPatronal()+" - taux salarial : "+this.getTauxSalarial();
		
		return text;
	}
}
