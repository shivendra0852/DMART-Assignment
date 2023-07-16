package com.dmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmart.exception.StockItemNotFoundException;
import com.dmart.model.StockItem;
import com.dmart.service.StockItemService;

@RestController
@RequestMapping("/DMart")
public class StockItemController {
	
	@Autowired
	private StockItemService stockItemService;
	
	@PostMapping("/addItem")
    public ResponseEntity<StockItem> addStockItem(@RequestBody StockItem stockItem) throws StockItemNotFoundException {
        StockItem addedStockItem = stockItemService.addStockItem(stockItem);
        return new ResponseEntity<>(addedStockItem, HttpStatus.CREATED);
    }
	
	@PutMapping("/updateItem/{name}")
    public ResponseEntity<StockItem> updateStockItemQuantity(@PathVariable String name, @RequestParam Integer quantity) throws StockItemNotFoundException {
        StockItem updatedStockItem = stockItemService.updateStockItemQuantity(name, quantity);
        return new ResponseEntity<>(updatedStockItem, HttpStatus.OK);
        
        //We can enter call the API in this way: .../updateItem/Colgate?quantity=10.
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public ResponseEntity<StockItem> deleteStockItem(@PathVariable Integer itemId) throws StockItemNotFoundException {
        StockItem deletedStockItem = stockItemService.deleteStockItem(itemId);
        return new ResponseEntity<>(deletedStockItem, HttpStatus.OK);
    }
}
