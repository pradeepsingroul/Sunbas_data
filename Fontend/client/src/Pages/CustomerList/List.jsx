import { useEffect, useState } from "react";
import { json } from "react-router-dom";
// import UserFetching from "./UserFetching";
import './List.css'
import axios from 'axios';

export default function List() {

    const [customers,setCustomers] = useState([])
    console.log('customers', customers);
    const [count,setCount] =  useState(0);

    useEffect(()=>{
        const fetchCustomers = async () => {
           const data = await fetch("http://localhost:8888/api/v1/customers/listAll")
           const dt= await data.json()
           setCustomers(dt)
          
          };
      
          fetchCustomers();
    },[])

    



      return (
        <table>
          <thead>
            <tr>
              <th>CustomerID</th>
              <th>FirstName</th>
              <th>LastName</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Street</th>
              <th>Address</th>
              <th>City</th>
              <th>State</th>
            </tr>
          </thead>
          <tbody>
            {customers.map((customer,index) => (
              <tr key={index}>
                <td>{customer.customerId}</td>
                <td>{customer.first_name}</td>
                <td>{customer.last_name}</td>
                <td>{customer.email}</td>
                <td>{customer.phone}</td>
                <td>{customer.street}</td>
                <td>{customer.address}</td>
                <td>{customer.city}</td>
                <td>{customer.state}</td>
              </tr>
            ))}
          </tbody>
        </table>
      );

}