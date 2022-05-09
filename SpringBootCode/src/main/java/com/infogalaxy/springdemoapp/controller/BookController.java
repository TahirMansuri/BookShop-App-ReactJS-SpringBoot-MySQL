package com.infogalaxy.springdemoapp.controller;

import com.infogalaxy.springdemoapp.dto.BookDTO;
import com.infogalaxy.springdemoapp.dto.ResponseDTO;
import com.infogalaxy.springdemoapp.model.BookData;
import com.infogalaxy.springdemoapp.service.IBookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/bookstore")
public class BookController {

    ArrayList<BookDTO> bookDTOArrayList = new ArrayList<>();

    @Autowired
    IBookStoreService bookStoreService;

    /***
     *
     * @return
     */
    @GetMapping(value={"","/","/home"})
    public String home() {
        return "<h1> Welcome to Book Store </h1>";
    }

    /***
     *
     * @param bookDTO
     * @return
     */
    @PostMapping("/addBook")
    public ResponseEntity<BookData> addBook(@RequestBody BookDTO bookDTO) {
        //bookDTOArrayList.add(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Call for POST success",bookDTO);
        return new ResponseEntity<BookData>(bookStoreService.addBook(bookDTO), HttpStatus.OK);
    }

    /***
     *
     * @return
     */
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookData>> getAllBooks() {
        //ResponseDTO responseDTO = new ResponseDTO("Call for GET Success",bookDTOArrayList);
        ResponseDTO responseDTO = new ResponseDTO("Call for GET Success",bookStoreService.getAllBooks());
        //return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
        return new ResponseEntity<List<BookData>>(bookStoreService.getAllBooks(),HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<ResponseDTO> updateBook(@PathVariable("id") int id, @RequestBody BookDTO bookDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Call for GET Success",bookStoreService.updateBook(id,bookDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<BookData> getBookById(@PathVariable int id) {
        BookData bookData = bookStoreService.getBookById(id);
        return ResponseEntity.ok(bookData);
    }

    @PutMapping("/updateBookById/{id}")
    public ResponseEntity<BookData> updateBookById(@PathVariable int id, @RequestBody BookDTO bookDTO){
        BookData bookData = bookStoreService.updateBookById(id, bookDTO);
        return ResponseEntity.ok(bookData);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable int id) {
        bookStoreService.deleteBookById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}