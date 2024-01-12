import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";




export default function Edit() {

    const user = useParams()
    const [customer, setCustomer] = useState({})



    useEffect(() => {
        fetchCustomerById(user.id)
    }, [])

    const fetchCustomerById = async (id) => {
        const data = await fetch(`http://localhost:8888/api/v1/customers?id=${id}`)
        const dt = await data.json()
        // console.log('data', data.data);
        console.log(dt,"dt")
        setCustomer(dt)
    }
    const handleChange= (event)=>{
        setCustomer({ ...customer, [event.target.name]: event.target.value })
    }


    const HandleSave = async (event) => {
        event.preventDefault();
        
        const saveData = fetch("http://localhost:8888/api/v1/customers", {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(customer)
            
        })
        console.log(customer)
        if(saveData.ok) { 
            alert("customer updated successfully") 
            
        }
    }

    return <div className="container">
        <h1>Change the details which you want to........</h1>
        <form action="" onSubmit={HandleSave}>
            <label htmlFor=""> FirstName:<input   onChange={handleChange} value={customer.first_name} placeholder="Enter your first Name" type="text" name="first_name" />
            </label>
            <label htmlFor="">LastName: <input  onChange={handleChange}  value={customer.last_name} placeholder="Enter your last name" type="text" name="last_name" />
            </label>
            <label htmlFor="">Street: <input  onChange={handleChange}  value={customer.street} placeholder="enter your Street" type="text" name="street" />
            </label>
            <label htmlFor="">Address:   <input   onChange={handleChange} value={customer.address} placeholder="Enter your Adrees" type="text" name="address" />
            </label>
            <label htmlFor="">City:  <input   onChange={handleChange} value={customer.city} placeholder="Enter your city" type="text" name="city" />
            </label>
            <label htmlFor="">State:    <input   onChange={handleChange} value={customer.state} placeholder="Enter your State" type="text" name="state" />
            </label>
            <label htmlFor="">Email: <input  onChange={handleChange}  value={customer.email} placeholder="enter your email" type="email" name="email" />
            </label>
            <label htmlFor=""> Phone: <input   onChange={handleChange} value={customer.phone} placeholder="enter your phone" type="phone" name="phone" />
            </label>
            <label htmlFor="">Password: <input  onChange={handleChange}  value={customer.password} placeholder="Enter your Password" type="password" name="password" />
            </label>
            <label htmlFor="">Button<input className="btn" type="submit" value={"Save"}/></label>
        </form>
    </div>


}