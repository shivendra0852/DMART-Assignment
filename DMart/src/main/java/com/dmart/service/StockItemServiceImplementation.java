package com.dmart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmart.exception.StockItemNotFoundException;
import com.dmart.model.StockItem;
import com.dmart.repository.StockItemDao;

@Service
public class StockItemServiceImplementation implements StockItemService{
	
	@Autowired
	private StockItemDao stockItemDao;

	@Override
	public StockItem addStockItem(StockItem stockItem) throws StockItemNotFoundException {
		
		Optional<StockItem> existingStockItemOptional = stockItemDao.findByName(stockItem.getName());

	    if (existingStockItemOptional.isPresent()) {
	        // Stock item already exists, update the quantity
	        StockItem existingStockItem = existingStockItemOptional.get();
	        existingStockItem.setQuantity(existingStockItem.getQuantity() + stockItem.getQuantity());

	        // Save the updated stock item
	        stockItemDao.save(existingStockItem);

	        return existingStockItem;
	    } else {
	        // Stock item doesn't exist, save the new stock item
	        stockItemDao.save(stockItem);

	        return stockItem;
	    }
	}

	@Override
	public StockItem updateStockItemQuantity(String name, Integer quantity) throws StockItemNotFoundException {
		
		if (name == null || name.isEmpty() || quantity == null) {
	        throw new IllegalArgumentException("Invalid name or quantity");
	    }

	    // Query the database to find the stock item by name
	    Optional<StockItem> stockItemOptional = stockItemDao.findByName(name);

	    if (stockItemOptional.isPresent()) {
	        StockItem stockItem = stockItemOptional.get();

	        // Update the quantity
	        stockItem.setQuantity(quantity);

	        // Save the updated stock item
	        stockItemDao.save(stockItem);

	        return stockItem;
	    } else {
	        throw new StockItemNotFoundException("Stock item not found with name: " + name);
	    }
	}

	@Override
	public StockItem deleteStockItem(Integer itemId) throws StockItemNotFoundException {
	    Optional<StockItem> existingStockItemOptional = stockItemDao.findById(itemId);

	    if (existingStockItemOptional.isPresent()) {
	        // Stock item exists, delete it
	        StockItem stockItem = existingStockItemOptional.get();

	        stockItemDao.delete(stockItem);

	        return stockItem;
	    } else {
	        throw new StockItemNotFoundException("Stock item not found with id: " + itemId);
	    }
	}

}
