package it.solvingteam.pccomponentsrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.solvingteam.pccomponentsrest.dto.PcDto;
import it.solvingteam.pccomponentsrest.dto.PcInsertDto;
import it.solvingteam.pccomponentsrest.mapper.PcMapper;
import it.solvingteam.pccomponentsrest.model.Pc;
import it.solvingteam.pccomponentsrest.repository.PcRepository;

@Service
public class PcService {

	@Autowired
	private PcRepository pcRepository;
	
	@Autowired
	private PcMapper pcMapper;
	
	public List<PcDto> findAll(){
		return pcMapper.convertEntityToDto(pcRepository.findAll());
	}
	
	public PcDto findById(Long id) {
		return pcMapper.convertEntityToDto(pcRepository.findById(id).get());
	}
	
	public void insertPc(PcInsertDto dto) {		
		pcRepository.save(pcMapper.convertDtoToEntity(dto));
	}
	
	public void updatePc(PcDto dto) {
		pcRepository.save(pcMapper.convertDtoToEntity(dto));
	}
	
	public void deletePc(Long id) throws Exception {
		Pc pcDaEliminare = pcRepository.findById(id).orElse(null);
		
		if(pcDaEliminare == null) {
			throw new Exception("id inesistente");
		}
		
		pcRepository.delete(pcDaEliminare);
	}
	
	
	
	
	
	
}
