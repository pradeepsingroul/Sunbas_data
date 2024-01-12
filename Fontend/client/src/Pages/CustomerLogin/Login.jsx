import { useState } from "react"
import {useNavigate} from 'react-router-dom'


export default function Login() {
    const [user, setUser] = useState({ email: "", password: "" })
    const navigate = useNavigate()
    const HandleInput = (event) => {

        console.log('event', event.target.value);
        setUser({ ...user, [event.target.name]: event.target.value })


    }

    const handleSubmit = async (event) => {

        event.preventDefault();

        try {
            const custo = await fetch(`http://localhost:8888/api/v1/customers/login?_email=${user.email}&_password=${user.password}`)
            const data = await custo.json();
            console.log(data);
            if (!data.status) {
                console.log('data', data);
                alert("customer login successfull.....")
                navigate('/');
            }else{
                alert("you have entered somthink wrong creatential....")
            }
        } catch (error) {

        }


    }



    return <div>
        <form action="" onSubmit={handleSubmit}>
            <label htmlFor="">Email: <input onChange={HandleInput} value={user.email} name="email" type="text" placeholder="enter your email" /> </label>
            <label htmlFor="">Password: <input onChange={HandleInput} value={user.password} name="password" type="text" placeholder="enter your password" /></label>
            <label htmlFor="">Button: <input type="submit" value={"Login"}/></label>
        </form>
    </div>
}