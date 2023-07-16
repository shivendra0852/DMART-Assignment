package com.dmart.exception;

@SuppressWarnings("serial")
public class StockItemExistException extends RuntimeException{
	public StockItemExistException() {
		
	}
	
	public StockItemExistException(String message) {
			super(message);
	}
}
