package net.javaguides.ims.service;

import java.util.List;

import net.javaguides.ims.entity.Inventory;

public interface InventoryService {
	List<Inventory> getAllInventories(); 
	
	Inventory saveInventory(Inventory inventory); 
	
	Inventory getInventoryById(Long id); 
	
	Inventory updateInventory(Inventory inventory); 
	
	void deleteInventoryById(Long id); 
}
