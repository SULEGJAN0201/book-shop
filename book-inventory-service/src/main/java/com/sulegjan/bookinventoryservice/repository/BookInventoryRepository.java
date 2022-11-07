package com.sulegjan.bookinventoryservice.repository;

import com.sulegjan.bookinventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookInventoryRepository extends JpaRepository<Inventory,Long> {


    Optional<Inventory> findBybookName();
}
