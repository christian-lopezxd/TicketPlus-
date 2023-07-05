import React from "react";
import AddTiersCard from "../../Components/Admin/AddTiersCard/AddTiersCard";
import Navbar from "../../Components/Admin/Navbar/Navbar";
import TiersContainer from "../../Components/Admin/TiersContainer/TiersContainer";


const AddTiers = () => {
    
    return(
        <section className="bg-backgroundicons bg-repeat min-h-[100vh] ">
        <Navbar />
        <div className="flex flex-col w-full justify-center">
        <div className="flex w-full justify-center">
        <AddTiersCard />
        </div>
        <TiersContainer />
        </div>
    </section>
    )

}


export default AddTiers;