package com.dmart.service;

import com.dmart.exception.StockItemNotFoundException;
import com.dmart.model.StockItem;

public interface StockItemService {
	
	public StockItem addStockItem(StockItem stockItem) throws StockItemNotFoundException;
	
	public StockItem updateStockItemQuantity(String name, Integer quantity) throws StockItemNotFoundException;
	
	public StockItem deleteStockItem(Integer itemId) throws StockItemNotFoundException;
}
