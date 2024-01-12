import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
// import UserFetching from "./UserFetching";
import './List.css'

import ListItem from "./ListItem";

export default function List() {

    const [customers, setCustomers] = useState([])
    console.log('customers', customers);
    const [count, setCount] = useState(0);

    useEffect(() => {
        const fetchCustomers = async () => {
            const data = await fetch(`http://localhost:8888/api/v1/customers/list?_page=${count}&_limit=2`)
            const dt = await data.json()
            console.log('dt', dt.content);
            setCustomers(dt.content)

        };

        fetchCustomers();
    }, [count])


    const handleDelete = async (id) => {
        // console.log('id', id);
        const response = await fetch(`http://localhost:8888/api/v1/customers?id=${id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        });
        if (response.ok) {
            const filterdata = customers.filter((cust) => {
                return cust.customerId != id;
            })
            setCustomers(filterdata)
            // console.log(customers)
        }

        // console.log(customers)

    }








    return (<>
        <div className="nav">
            <div>
                <button><Link to={"/signup"}>Add Customer</Link></button>
            </div>
            <div> <button><Link to={"/login"}>Login</Link></button></div>

            <select  >
                <option value="city">city</option>
                <option value="first_name">firstName</option>
                <option value="last_name">lastName</option>
                <option value="state">state</option>
                <option value="street">Street</option>
                <option value="address">address</option>
                <option value="customerId">customerId</option>
            </select>

        </div>

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
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                {customers.map((customer, index) => {
                    return <ListItem key={customer.customerId} customer={customer} handleDelete={handleDelete} />
                })}
            </tbody>
        </table>

        <div style={{ display: "flex", marginTop: "20px", height: "30px", alignItems: "center", justifyContent: "center" }}>
            <button disabled={count == 0 ? true : false} onClick={() => setCount(count - 1)}>PREV</button>
            <h2>{count}</h2>
            <button onClick={() => setCount(count + 1)}>NEXT</button>
        </div>
    </>
    );

}