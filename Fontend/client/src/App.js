
import './App.css';
import Login from './Pages/CustomerLogin/Login';
import List from './Pages/CustomerList/List';
import Signup from './Pages/CreateCustomer/Signup';

function App() {
  return (
    <div className="App">
      {/* <Login/> */}
      <Signup/>

      <Login/>


      <List/>
    </div>
  );
}

export default App;
