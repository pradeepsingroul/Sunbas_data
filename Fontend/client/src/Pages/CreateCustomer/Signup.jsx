import { useState } from "react"
import './Signup.css'



export default function Signup(){
    const schema = {
        customerId: 0,
        first_name: "",
        last_name: "",
        street: "",
        address: "",
        city:"",
        state:"",
        email:"",
        phone:"",
        password: ""
    }
    
    const [customer,setCustomer]= useState(schema)

    const hanldeformData = (event)=>{
        setCustomer({...customer,[event.target.name]:event.target.value})
    }
    const HandleSubmit = (event)=>{
        event.preventDefault()
        console.log(customer)
    }



    return <div className="container">
        <form action="" onSubmit={HandleSubmit}>
            <input onChange={hanldeformData} value={customer.first_name} placeholder="Enter your first Name" type="text"  name="first_name"/>
            <input onChange={hanldeformData} value={customer.last_name} placeholder="Enter your last name" type="text"  name="last_name"/>
            <input onChange={hanldeformData} value={customer.street} placeholder="enter your Street" type="text"  name="street"/>
            <input onChange={hanldeformData} value={customer.address} placeholder="Enter your Adrees" type="text"  name="address"/>
            <input onChange={hanldeformData} value={customer.city} placeholder="Enter your city" type="text"  name="city"/>
            <input onChange={hanldeformData} value={customer.state} placeholder="Enter your State" type="text"  name="state"/>
            <input onChange={hanldeformData} value={customer.email} placeholder="enter your email" type="email" name="email" />
            <input onChange={hanldeformData} value={customer.phone} placeholder="enter your phone" type="phone" name="phone" />
            <input onChange={hanldeformData} value={customer.password} placeholder="Enter your Password" type="password" name="password"/>
            <input className="btn" type="submit" />
        </form>
    </div>
}