package com.infogalaxy.springdemoapp.service;

import com.infogalaxy.springdemoapp.dto.BookDTO;
import com.infogalaxy.springdemoapp.model.BookData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookStoreService {

    public BookData addBook(BookDTO bookDTO);

    List<BookData> getAllBooks();

    public BookData updateBook(int id, BookDTO bookDTO);

    BookData getBookById(int id);

    BookData updateBookById(int id, BookDTO bookDTO);

    void deleteBookById(int id);

}
