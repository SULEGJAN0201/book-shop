package com.sulegjan.bookinventoryservice.service;


import com.sulegjan.bookinventoryservice.repository.BookInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BookInventoryService {
    private final BookInventoryRepository bookInventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String bookName){
        return bookInventoryRepository.findBybookName().isPresent();
    }
}
