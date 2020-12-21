package it.solvingteam.pccomponentsrest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String marca;
	
	private String descrizione;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pc", cascade = CascadeType.REMOVE)
	private List<Device> listaComponenti = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Device> getListaComponenti() {
		return listaComponenti;
	}

	public void setListaComponenti(List<Device> listaComponenti) {
		this.listaComponenti = listaComponenti;
	}
	
	
}
