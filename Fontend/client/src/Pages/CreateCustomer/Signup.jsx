import { useState } from "react"
import './Signup.css'



export default function Signup() {
    const schema = {
        customerId: 0,
        first_name: "",
        last_name: "",
        street: "",
        address: "",
        city: "",
        state: "",
        email: "",
        phone: "",
        password: ""
    }

    const [customer, setCustomer] = useState(schema)

    const hanldeformData = (event) => {
        setCustomer({ ...customer, [event.target.name]: event.target.value })
    }
    const HandleSubmit = (event) => {
        event.preventDefault()
        console.log(customer)
    }



    return <div className="container">
        <h2>Enter customer Details</h2>
        <form action="" onSubmit={HandleSubmit}>
            <label htmlFor=""> FirstName:<input onChange={hanldeformData} value={customer.first_name} placeholder="Enter your first Name" type="text" name="first_name" />
            </label>
            <label htmlFor="">LastName: <input onChange={hanldeformData} value={customer.last_name} placeholder="Enter your last name" type="text" name="last_name" />
            </label>
            <label htmlFor="">Street: <input onChange={hanldeformData} value={customer.street} placeholder="enter your Street" type="text" name="street" />
            </label>
            <label htmlFor="">Address:   <input onChange={hanldeformData} value={customer.address} placeholder="Enter your Adrees" type="text" name="address" />
            </label>
            <label htmlFor="">City:  <input onChange={hanldeformData} value={customer.city} placeholder="Enter your city" type="text" name="city" />
            </label>
            <label htmlFor="">State:    <input onChange={hanldeformData} value={customer.state} placeholder="Enter your State" type="text" name="state" />
            </label>
            <label htmlFor="">Email: <input onChange={hanldeformData} value={customer.email} placeholder="enter your email" type="email" name="email" />
            </label>
            <label htmlFor=""> Phone: <input onChange={hanldeformData} value={customer.phone} placeholder="enter your phone" type="phone" name="phone" />
            </label>
            <label htmlFor="">Password: <input onChange={hanldeformData} value={customer.password} placeholder="Enter your Password" type="password" name="password" />
            </label>
            <label htmlFor="">Button<input className="btn" type="submit" /></label>
        </form>
    </div>
}