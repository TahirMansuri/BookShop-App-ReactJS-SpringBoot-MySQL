package com.infogalaxy.springdemoapp.service;

import com.infogalaxy.springdemoapp.dto.BookDTO;
import com.infogalaxy.springdemoapp.exception.ResourceNotFoundException;
import com.infogalaxy.springdemoapp.model.BookData;
import com.infogalaxy.springdemoapp.repository.BookStoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookStoreServiceImpl implements IBookStoreService{

    @Autowired
    BookStoreRepo bookStoreRepo;

    @Override
    public BookData addBook(BookDTO bookDTO) {
        BookData bookData = new BookData(bookDTO);
        return bookStoreRepo.save(bookData);
    }

    @Override
    public List<BookData> getAllBooks() {
        return bookStoreRepo.findAll();
    }

    @Override
    public BookData updateBook(int id, BookDTO bookDTO) {
        BookData bookData = bookStoreRepo.findBookDataById(id);
        bookData.updateBookData(bookDTO);
        return bookStoreRepo.save(bookData);
    }

    @Override
    public BookData getBookById(int id) {
        return bookStoreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not exist by ID : "+ id));
    }

    @Override
    public BookData updateBookById(int id, BookDTO bookDTO) {
        BookData bookData = bookStoreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Exist By ID : "+id));
        bookData.updateBookData(bookDTO);
        return bookStoreRepo.save(bookData);
    }

    @Override
    public void deleteBookById(int id) {
        BookData bookData = bookStoreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Exist with ID : " + id));
        bookStoreRepo.delete(bookData);
    }
}
