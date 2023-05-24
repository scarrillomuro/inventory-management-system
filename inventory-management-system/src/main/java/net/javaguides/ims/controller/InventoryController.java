package net.javaguides.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.ims.entity.Inventory;
import net.javaguides.ims.service.InventoryService;


// handles all request
@Controller
public class InventoryController {
	
	private InventoryService inventoryService;

	public InventoryController(InventoryService inventoryService) {
		super();
		this.inventoryService = inventoryService;
	}
	
	// handler method to handle list of inventory request and return a mode and view
	@GetMapping("/inventories")
	public String listInventory(Model model) {
		model.addAttribute("inventories", inventoryService.getAllInventories());
		return "inventories";	
	}
	
	@GetMapping("/inventories/new")
	public String createInventoryForm(Model model) {
		
		// create inventory object to hold new inventory form data
		Inventory inventory = new Inventory(); 
		model.addAttribute("inventory", inventory); 
		return "create_inventory";
	}
	
	@PostMapping("/inventories")
	public String saveInventory(@ModelAttribute("inventory") Inventory inventory){
		inventoryService.saveInventory(inventory);
		return "redirect:/inventories"; 		
	}
	
	@GetMapping("/inventories/edit/{id}")
	public String editInventoryForm(@PathVariable Long id, Model model) {
		model.addAttribute("inventory", inventoryService.getInventoryById(id)); 
		return "edit_inventory"; 
	}
	
	// create method to handle edit request 
	
	@PostMapping("/inventories/{id}")
	public String updateInventory(@PathVariable Long id, 
			@ModelAttribute("inventory") Inventory inventory,
			Model model){
		
		// get inventory from database by id 
		Inventory existingInventory = inventoryService.getInventoryById(id); 
		existingInventory.setId(id); 
		existingInventory.setProductName(inventory.getProductName()); 
		existingInventory.setProductCost(inventory.getProductCost()); 
		existingInventory.setProductUnitOfMeasure(inventory.getProductUnitOfMeasure()); 
		existingInventory.setProductQuantity(inventory.getProductQuantity()); 
		existingInventory.setProductDescription(inventory.getProductDescription()); 
		
		// save updated inventory object
		inventoryService.updateInventory(existingInventory);
		return "redirect:/inventories"; 
		
	}
	
	// handler method to delete inventory request
	@GetMapping("/inventories/{id}")
	public String deleteInventory(@PathVariable Long id) {
		inventoryService.deleteInventoryById(id); 
		return "redirect:/inventories"; 
	}
	
	

}
