package com.sulegjan.bookinventoryservice.controller;

import com.sulegjan.bookinventoryservice.service.BookInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class BookInventoryController {

    private final BookInventoryService bookInventoryService;
     @GetMapping("/{book-name}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("book-name") String bookName){
          return bookInventoryService.isInStock(bookName);
     }

}
