import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import BookStoreService from "../services/BookStoreService";

const ListBooksComponent = () => {

    const [books, setBooks] = useState([])

    useEffect(() => {
        getAllBooks();
    }, [])
    
    const getAllBooks = () => {
        BookStoreService.getAllBooks().then((response)=>
                                            {
                                            setBooks(response.data)
                                            console.log(response.data)
                                            })
                                            .catch(error => {
                                                console.log(error);
                                            })
    }

    const deleteBookById = (id) => {
            console.log(id);
        BookStoreService.deleteBookById(id).then((response) => {
            console.log("Book Deleted");
            getAllBooks();
        }).catch(error => {
            console.log(error);
        });
    }

  return( 
        <div className="container">
            <h2 className="text-center"> Books List </h2>

            <Link to = "/add-book" className="btn btn-primary mb-2"> ADD BOOK </Link>

            <table className="table table-bordered table-striped">
                <thead>
                    <th> Bood ID </th>
                    <th> Book Code </th>
                    <th> Book Name </th>
                    <th> No. Of Pages </th>
                    <th> Price </th>
                    <th> Author </th>
                    <th> Quantity </th>
                    <th> Publisher </th> 
                    <th> Actions </th>
                </thead>
                <tbody>

                    {
                        books.map(
                            book => 
                            <tr key = {book.id}>
                                <td> {book.id} </td>
                                <td> {book.bookCode} </td>
                                <td> {book.bookName} </td>
                                <td> {book.noOfPages} </td>
                                <td> {book.price} </td>
                                <td> {book.author} </td>
                                <td> {book.quantity} </td>
                                <td> {book.publisher} </td>
                                <td>
                                    <Link to={`/getBookById/${book.id}`} className="btn btn-info"> UPDATE </Link>
                                    <button className="btn btn-danger" onClick={() => deleteBookById(book.id)} style={{marginLeft: "10px"}}> DELETE </button>
                                </td>
                            </tr>
                        )
                    }

                </tbody>
            </table>
        </div>
      );
};

export default ListBooksComponent;
