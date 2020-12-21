package it.solvingteam.pccomponentsrest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.solvingteam.pccomponentsrest.dto.DeviceDto;
import it.solvingteam.pccomponentsrest.model.Device;

@Component
public class DeviceMapper extends AbstractMapper<Device, DeviceDto> {

	@Autowired
	private PcMapper pcMapper;
	
	@Override
	public DeviceDto convertEntityToDto(Device entity) {
		
		if (entity == null) {
            return null;
        }
		
		DeviceDto dto = new DeviceDto();
		
		dto.setId(String.valueOf(entity.getId()));
		dto.setMarca(entity.getMarca());
		dto.setDescrizione(entity.getDescrizione());
		dto.setCodice(entity.getCodice());
		dto.setPcDto(pcMapper.convertEntityToDto(entity.getPc()));
		
		return dto;
		
		
	}

	@Override
	public Device convertDtoToEntity(DeviceDto dto) {
		
		if (dto == null) {
            return null;
        }
		
		Device entity = new Device();
		
		if(dto.getId() != null) {
			entity.setId(Long.valueOf(dto.getId()));
		}
		
		entity.setMarca(dto.getMarca());
		entity.setDescrizione(dto.getDescrizione());
		entity.setCodice(dto.getCodice());
		entity.setPc(pcMapper.convertDtoToEntity(dto.getPcDto()));
		
		return entity;
		
	}

}
