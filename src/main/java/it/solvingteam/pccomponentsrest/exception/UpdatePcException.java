package it.solvingteam.pccomponentsrest.exception;

import org.springframework.validation.BindingResult;

public class UpdatePcException extends Exception{
	
	private BindingResult bindingResult;

	public UpdatePcException(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	
	

}
