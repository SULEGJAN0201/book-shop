package com.sulegjan.bookinventoryservice;

import com.sulegjan.bookinventoryservice.model.Inventory;
import com.sulegjan.bookinventoryservice.repository.BookInventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookInventoryServiceApplication.class, args);

	}
	@Bean
	public CommandLineRunner LoadData(BookInventoryRepository bookInventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setBookName("story1234");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setBookName("storyone");
			inventory1.setQuantity(10);

			bookInventoryRepository.save(inventory);
			bookInventoryRepository.save(inventory1);



		};
	}

}
