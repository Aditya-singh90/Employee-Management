
import './App.css'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import FooterComponent from './components/FooterComponent'
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import EmployeeComponentt from './components/EmployeeComponentt'


function App() {
 
  

  return (
    <>
    <BrowserRouter>
        <HeaderComponent/>
        <Routes>
          {/*// http://localhost:5173 */}
          <Route path='/' element={<ListEmployeeComponent/>}></Route>
            {/* // http://localhost:5173/employees */ }
           <Route path='/employees' element={<ListEmployeeComponent/>}></Route>
             {/* // http://localhost:5173/add-employee */ }
           <Route path='/add-employee' element={<EmployeeComponentt/>}></Route>

           {/* // http://localhost:5173/edit-employee/1 */ }
           <Route path='/edit-employee/:id' element = {<EmployeeComponentt/>}></Route>
        </Routes>
        <FooterComponent/>
        </BrowserRouter>
        
   </>
  )
}

export default App
