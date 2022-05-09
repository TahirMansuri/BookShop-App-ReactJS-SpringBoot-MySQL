package com.infogalaxy.springdemoapp.dto;

import lombok.Data;

@Data
public class BookDTO {
    private String bookCode;
    private String bookName;
    private String noOfPages;
    private String price;
    private String author;
    private int quantity;
    private String publisher;
}
