import { useEffect, useState } from "react";



export default function List(){



    const value = {
        id: 1,
        name: "pradeep"
    }

    useEffect(()=>{
        localStorage.setItem("odento",JSON.stringify(value));
    },[])

    return <div>
    </div>
}