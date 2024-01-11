import { Link } from "react-router-dom";



export default function ListItem({customer,handleDelete}) {
    
    

    return <tr key={customer.customerId}>
        <td>{customer.customerId}</td>
        <td>{customer.first_name}</td>
        <td>{customer.last_name}</td>
        <td>{customer.email}</td>
        <td>{customer.phone}</td>
        <td>{customer.street}</td>
        <td>{customer.address}</td>
        <td>{customer.city}</td>
        <td>{customer.state}</td>
        <td>
            <button><Link to={`/edit/${customer.customerId}`}>Edit</Link></button>
            <button onClick={() => handleDelete(customer.customerId)}>Delete</button>
        </td>
    </tr>
}