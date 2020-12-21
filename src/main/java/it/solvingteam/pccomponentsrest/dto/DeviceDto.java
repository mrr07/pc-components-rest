package it.solvingteam.pccomponentsrest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DeviceDto {

	@NotNull(message = "id doesn't exist")
	private String id;
	
	@NotEmpty(message = "marca is required")
	private String marca;
	
	@NotEmpty(message = "codice is required")
	private String codice;
	
	@NotEmpty(message = "descrizione is required")
	private String descrizione;
	
	private PcDto pcDto;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public PcDto getPcDto() {
		return pcDto;
	}

	public void setPcDto(PcDto pcDto) {
		this.pcDto = pcDto;
	}
	
	
}
