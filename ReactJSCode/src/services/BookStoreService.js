import axios from "axios";

const BOOK_STORE_BASE_URL = "http://localhost:8080/bookstore/";


class BookStoreService {
    getAllBooks() {
        return axios.get(BOOK_STORE_BASE_URL+"getAllBooks");
    }

    addBook(book) {
        return axios.post(BOOK_STORE_BASE_URL + "addBook", book);
    }

    getBookById(id) {
        return axios.get(BOOK_STORE_BASE_URL +"getBookById/" + id);
    }

    updateBookById(id, book) {
        return axios.put(BOOK_STORE_BASE_URL + "updateBookById/" + id, book);
    }

    deleteBookById(id) {
        return axios.delete(BOOK_STORE_BASE_URL + "deleteBookById/" + id);
    }
}
export default new BookStoreService();