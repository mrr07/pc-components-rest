package it.solvingteam.pccomponentsrest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.solvingteam.pccomponentsrest.dto.PcDto;
import it.solvingteam.pccomponentsrest.dto.PcInsertDto;
import it.solvingteam.pccomponentsrest.model.Pc;

@Component
public class PcMapper extends AbstractMapper<Pc, PcDto> {

	@Autowired
	private DeviceMapper deviceMapper;
	
	@Override
	public PcDto convertEntityToDto(Pc entity) {
		
		if (entity == null) {
            return null;
        }
		
		PcDto dto = new PcDto();
		
		dto.setId(String.valueOf(entity.getId()));
		dto.setMarca(entity.getMarca());
		dto.setDescrizione(entity.getDescrizione());
		dto.setListaDeviceDto(deviceMapper.convertEntityToDto(entity.getListaComponenti()));
		
		
		return dto;
	}

	@Override
	public Pc convertDtoToEntity(PcDto dto) {
		
		if (dto == null) {
            return null;
        }
		
		Pc entity = new Pc();
		
		if(dto.getId() != null) {
			entity.setId(Long.valueOf(dto.getId()));
		}
		
		entity.setMarca(dto.getMarca());
		entity.setDescrizione(dto.getDescrizione());
		entity.setListaComponenti(deviceMapper.convertDtoToEntity(dto.getListaDeviceDto()));
		
		return entity;
	}

	public Pc convertDtoToEntity(PcInsertDto dto) {
		
		if (dto == null) {
            return null;
        }
		
		Pc entity = new Pc();
		
		entity.setMarca(dto.getMarca());
		entity.setDescrizione(dto.getDescrizione());
		entity.setListaComponenti(deviceMapper.convertDtoToEntity(dto.getListaDeviceDto()));
		
		return entity;
		
		
	}

}
