import React from "react";
import TicketContainer from "./TicketContainer/TicketContainer";

const Bundle = () => {
    return(
        <div className="flex flex-col">
                <h1 className="font-montserrat font-bold text-3xl text-white w-fit pl-5 ">Compra n° 1</h1>
                <TicketContainer />
               
        </div>
    )
}

export default Bundle;