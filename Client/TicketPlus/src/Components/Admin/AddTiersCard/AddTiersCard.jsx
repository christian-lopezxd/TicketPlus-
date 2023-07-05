import React from "react";
import { useState } from "react";
import { useParams } from "react-router";
import EventServices from "../../../Services/EventServices";





const AddTiersCard = () => {


    const params = useParams().id;
    

    const [tier, setTier] = useState("")
    const [price, setPrice] = useState("")
    const [capacity, setCapacity] = useState("")

    
    const Create = (e) => {
        e.preventDefault();
        if(!tier || !price || !capacity){
            alert("Please fill the fields")
            return;
        }
        
        EventServices.addTier(params, tier, price, capacity)
         
        
        
        setTier("");
        setCapacity("");
        setPrice("");

       
         
        
    }
       


    


return(
    <div className="bg-grissoft text-white w-[50%] rounded-xl mt-5 px-5 py-5 justify-center font-bold text-xl items-center">
        <form className="flex flex-col gap-2" onSubmit={(e) => Create(e)}>
            <label>Tier name: </label>
            <input type="name" value={tier} onChange={(e) => setTier(e.target.value)} className="text-black p-2 ml-5 rounded w-[50%] "placeholder="enter tier name"></input>
            <label>Tier price: </label>
            <input  type="number" value={price} onChange={(e) => setPrice(e.target.value)} step="0.5" className="text-black p-2 ml-5 rounded w-[50%] "placeholder="enter tier price "></input>
            <label>Tier capacity: </label>
            <input type="number" value={capacity} onChange={(e) => setCapacity(e.target.value)}className="text-black p-2 ml-5 rounded w-[50%] "placeholder="enter tier capacity "></input>
            <div className="flex justify-center pt-4 "><button type="submit"  className="bg-[#374259] hover:bg-[#2C3547] w-[30%] p-3"> Add</button></div>
        </form>

    </div>
)

}
export default AddTiersCard;