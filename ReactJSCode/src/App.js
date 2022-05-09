import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListBooksComponent from './components/ListBooksComponent';
import AddBookComponent from './components/AddBookComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
          <div className='container'>
            <Routes>
              <Route path="/" element={<ListBooksComponent />}></Route>
              <Route path='/getAllBooks' element={<ListBooksComponent />}></Route>
              <Route path="/add-book" element={<AddBookComponent />}></Route>
              <Route path='/getBookById/:id' element={<AddBookComponent />} ></Route>
            </Routes>
          </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
