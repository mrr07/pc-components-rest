package it.solvingteam.pccomponentsrest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.solvingteam.pccomponentsrest.dto.MessageDto;
import it.solvingteam.pccomponentsrest.dto.PcDto;
import it.solvingteam.pccomponentsrest.dto.PcInsertDto;
import it.solvingteam.pccomponentsrest.exception.InsertPcException;
import it.solvingteam.pccomponentsrest.exception.UpdatePcException;
import it.solvingteam.pccomponentsrest.mapper.PcMapper;
import it.solvingteam.pccomponentsrest.service.PcService;

@RestController
@RequestMapping("pc")
public class PcController {
	
	@Autowired
	private PcService pcService;
	
	@PostMapping("insert")
	public ResponseEntity<MessageDto> insert(@Valid @RequestBody PcInsertDto pcInsertDto, BindingResult bindingResult) throws InsertPcException {
		List<String> messages = new ArrayList<>();
		if(bindingResult.hasErrors()) {	
			throw new InsertPcException(bindingResult);
		}
		
		pcService.insertPc(pcInsertDto);
		messages.add("Inserimento eseguito correttamente");
		return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(messages));
		
	}
	
	@GetMapping("findAll")
	public List<PcDto> findAll(){
		
		return pcService.findAll();
		
	}

	@GetMapping("findById/{id}")
	public PcDto findById(@PathVariable Long id) {
		return pcService.findById(id);
		
	}
	
	@PutMapping("update")
	public ResponseEntity<MessageDto> update(@Valid @RequestBody PcDto dto, BindingResult bindingResult) throws UpdatePcException{
		List<String> messages = new ArrayList<>();
		if(bindingResult.hasErrors()) {	
			throw new UpdatePcException(bindingResult);
		}
		
		pcService.updatePc(dto);
		messages.add("Modifica eseguita correttamente");
		return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(messages));
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<MessageDto> delete(@PathVariable Long id) throws Exception{
		List<String> messages = new ArrayList<>();
		try {
			pcService.deletePc(id);
			messages.add("Eliminazione completata con successo");
			return ResponseEntity.status(HttpStatus.OK).body(new MessageDto(messages));
		} catch (Exception e) {
			messages.add(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageDto(messages));
		}
		
		
	}
	
	@ExceptionHandler(InsertPcException.class)
	public ResponseEntity<MessageDto> exceptionHandlerForInsert(InsertPcException e){
		List<String> messages = new ArrayList<>();
		List<FieldError> listaErrori = new ArrayList<>();
		listaErrori = e.getBindingResult().getFieldErrors();
		for (FieldError error : listaErrori) {
			messages.add(error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageDto(messages));
		
	}
	
	@ExceptionHandler(UpdatePcException.class)
	public ResponseEntity<MessageDto> exceptionHandlerForUpdate(UpdatePcException e){
		List<String> messages = new ArrayList<>();
		List<FieldError> listaErrori = new ArrayList<>();
		listaErrori = e.getBindingResult().getFieldErrors();
		for (FieldError error : listaErrori) {
			messages.add(error.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageDto(messages));
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MessageDto> exceptionHandler(Exception e){
		List<String> messages = new ArrayList<>();
		messages.add(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageDto(messages));
		
	}
	
	
	

}
