package it.solvingteam.pccomponentsrest.exception;

import org.springframework.validation.BindingResult;

public class InsertPcException extends Exception {
	
	private BindingResult bindingResult;

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public InsertPcException(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
	
	

}
