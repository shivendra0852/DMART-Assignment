package com.dmart.exception;

@SuppressWarnings("serial")
public class StockItemNotFoundException extends RuntimeException{
	public StockItemNotFoundException() {
		
	}
	
	public StockItemNotFoundException(String message) {
		super(message);
	}
}
