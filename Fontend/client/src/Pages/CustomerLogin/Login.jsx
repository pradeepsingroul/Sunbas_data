import { useState } from "react"



export default function Login() {
    const[user,setUser] = useState({email: "", password: ""})

    const HandleInput = (event)=>{

            console.log('event', event.target.value);
            setUser({...user,[event.target.name]:event.target.value})
            

    }

    const handleSubmit = (event)=>{

        event.preventDefault();
    
        // integration of api 

    }



    return <div>
        <form action="" onSubmit={handleSubmit}>
            <input onChange={HandleInput} value={user.email} name="email"  type="text" placeholder="enter your email" />
            <input onChange={HandleInput} value={user.password} name="password" type="text" placeholder="enter your password" />
            <input type="submit" />
        </form>
    </div>
}