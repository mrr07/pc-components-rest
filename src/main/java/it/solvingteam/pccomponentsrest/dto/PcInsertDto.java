package it.solvingteam.pccomponentsrest.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class PcInsertDto {

	private String id;
	
	@NotEmpty(message = "marca is required")
	private String marca;
	
	@NotEmpty(message = "descrizione is required")
	private String descrizione;
	
	private List<DeviceDto> listaDeviceDto = new ArrayList<>();

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<DeviceDto> getListaDeviceDto() {
		return listaDeviceDto;
	}

	public void setListaDeviceDto(List<DeviceDto> listaDeviceDto) {
		this.listaDeviceDto = listaDeviceDto;
	}
	
}
