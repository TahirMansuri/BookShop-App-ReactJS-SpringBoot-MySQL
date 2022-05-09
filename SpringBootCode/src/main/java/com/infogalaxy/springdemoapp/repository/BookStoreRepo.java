package com.infogalaxy.springdemoapp.repository;

import com.infogalaxy.springdemoapp.dto.BookDTO;
import com.infogalaxy.springdemoapp.model.BookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepo extends JpaRepository<BookData,Integer> {
    BookData findBookDataById(int id);
}
