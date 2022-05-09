package com.infogalaxy.springdemoapp.model;

import com.infogalaxy.springdemoapp.dto.BookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BookData")
public class BookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookCode;
    private String bookName;
    private String noOfPages;
    private String price;
    private String author;
    private int quantity;
    private String publisher;

    public BookData(int id, String bookCode, String bookName, String noOfPages, String price, String author, int quantity, String publisher) {
        this.id = id;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.noOfPages = noOfPages;
        this.price = price;
        this.author = author;
        this.quantity = quantity;
        this.publisher = publisher;
    }

    public BookData(BookDTO bookDTO) {
        this.bookCode = bookDTO.getBookCode();
        this.bookName = bookDTO.getBookName();
        this.noOfPages = bookDTO.getNoOfPages();
        this.price = bookDTO.getPrice();
        this.author = bookDTO.getAuthor();
        this.quantity = bookDTO.getQuantity();
        this.publisher = bookDTO.getPublisher();
    }

    public void updateBookData(BookDTO bookDTO) {
        this.bookCode = bookDTO.getBookCode();
        this.bookName = bookDTO.getBookName();
        this.noOfPages = bookDTO.getNoOfPages();
        this.price = bookDTO.getPrice();
        this.author = bookDTO.getAuthor();
        this.quantity = bookDTO.getQuantity();
        this.publisher = bookDTO.getPublisher();
    }

}
