package it.jac.projectwork.dto;

import lombok.Data;

@Data
public class Response<T> {
	
	private T result;
	
	private boolean resultTest;
	
	private String error;
}
