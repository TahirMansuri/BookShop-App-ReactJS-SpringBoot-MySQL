import React, {useState, useEffect} from 'react'
import BookStoreService from '../services/BookStoreService'
import { useNavigate, useParams } from 'react-router-dom';
import { Link } from "react-router-dom";
const AddBookComponent = () => {

    const [bookCode, setBookCode] = useState('')
    const [bookName, setBookName] = useState('')
    const [noOfPages, setNoOfPages] = useState('')
    const [price, setPrice] = useState('')
    const [author, setAuthor] = useState('')
    const [quantity, setQuantity] = useState('')
    const [publisher, setPublisher] = useState('')

    const {id} = useParams();

    console.log(id);

    const navigate = useNavigate();

    const saveOrUpdateBook = (e) => {
        e.preventDefault();
        const book = {bookCode, bookName, noOfPages, price, author, quantity, publisher};
        console.log(book);

        if(id){
                BookStoreService.updateBookById(id,book).then((response) => {
                    navigate("/getAllBooks");
                }).catch(error=> {
                    console.log(error);
                });
        }else {
                BookStoreService.addBook(book).then((response) =>{
                    console.log(response.data);
                    navigate("/getAllBooks");
            }).catch(error => {
                console.log(error);
            });
        }
    }

    useEffect(() => {
        BookStoreService.getBookById(id).then((response)=>
        {
            setBookCode(response.data.bookCode);
            setBookName(response.data.bookName);
            setNoOfPages(response.data.noOfPages);
            setPrice(response.data.price);
            setAuthor(response.data.author);
            setQuantity(response.data.quantity);
            setPublisher(response.data.publisher);
        }).catch(error => {
            console.log(error);
        });
    }, [])
    
    const title = () => {
        if(id){
           return <h1 className='text-center'> UPDATE BOOK </h1>
        }else {
           return <h1 className='text-center'> ADD BOOK </h1>
        }
    }

  return (
    <div>
        <div className='container'>

            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    {
                        title()
                    }
                    <div className='card-body'>
                        <form>
                            
                            <div className='form-group mb-2'>
                                <label className='form-label'> Book Code : </label>
                                <input type="text" placeholder="Enter the Book Code" name="bookCode" className='form-control'
                                    value={bookCode}
                                    onChange= {(e) => setBookCode(e.target.value)}
                                ></input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'> Book Name : </label>
                                <input type="text" placeholder="Enter the Book Name" name="bookName" className='form-control'
                                    value={bookName}
                                    onChange= {(e) => setBookName(e.target.value)}
                                ></input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'> Book No. Of Pages : </label>
                                <input type="text" placeholder="Enter the Book No. Of Pages" name="noOfPages" className='form-control'
                                    value={noOfPages}
                                    onChange= {(e) => setNoOfPages(e.target.value)}
                                ></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'> Book Price : </label>
                                <input type="text" placeholder="Enter the Book Price" name="price" className='form-control'
                                    value={price}
                                    onChange= {(e) => setPrice(e.target.value)}
                                ></input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'> Book Author : </label>
                                <input type="text" placeholder="Enter the Book Author" name="author" className='form-control'
                                    value={author}
                                    onChange= {(e) => setAuthor(e.target.value)}
                                ></input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'> Book Quantity : </label>
                                <input type="text" placeholder="Enter the Book Quantity" name="quantity" className='form-control'
                                    value={quantity}
                                    onChange= {(e) => setQuantity(e.target.value)}
                                ></input>
                            </div>

                            <div className='form-group mb-2'>
                                <label className='form-label'> Book Publisher : </label>
                                <input type="text" placeholder="Enter the Book Publisher" name="publisher" className='form-control'
                                    value={publisher}
                                    onChange= {(e) => setPublisher(e.target.value)}
                                ></input>
                            </div>

                            <button className='btn btn-success' onClick={(e) => saveOrUpdateBook(e)}> SUBMIT </button>

                            <Link to="/getAllBooks" className="btn btn-danger "> CANCEL </Link>

                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
  )
}

export default AddBookComponent