package com.dmart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmart.model.StockItem;


public interface StockItemDao extends JpaRepository<StockItem, Integer>{
	
	Optional<StockItem> findByName(String name);

}
