import { Route, Router, Routes } from "react-router-dom";
import Signup from "./CreateCustomer/Signup";
import List from "./CustomerList/List";
import Login from "./CustomerLogin/Login";
import Edit from "./Edit/Edit";



export default function Allroutes() {


    return <div>
        <Routes>

            <Route path="/signup" element={<Signup />} />
            <Route path="/" element={<List />} />
            <Route path="/login" element={<Login />} />
            <Route path="/edit/:id" element={<Edit />} />

        </Routes>
    </div>
}