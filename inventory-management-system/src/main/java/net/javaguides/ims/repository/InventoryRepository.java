package net.javaguides.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.ims.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

}
 