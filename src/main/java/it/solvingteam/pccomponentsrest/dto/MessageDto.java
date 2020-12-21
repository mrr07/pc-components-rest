package it.solvingteam.pccomponentsrest.dto;

import java.util.ArrayList;
import java.util.List;

public class MessageDto {

	private List<String> messages = new ArrayList<>();

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public MessageDto(List<String> messages) {
		this.messages = messages;
	}

	

	
	
}
