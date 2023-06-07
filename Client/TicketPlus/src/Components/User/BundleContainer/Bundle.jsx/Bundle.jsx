import React from "react";
import TicketContainer from "./TicketContainer/TicketContainer";

const Bundle = () => {
    return(
        <div className="flex flex-col md:items-center">
                <div className="bg-grissoft flex justify-center items-center mx-5 px-5 py-2 rounded-2xl md:w-full md:rounded sm:rounded-2xl  md:m-0 w-fit"><h1 className="font-Lilit font-bold text-3xl text-white w-fit  stroke-black ">Compra n° 1</h1></div>
                <TicketContainer />
               
        </div>
    )
}

export default Bundle;