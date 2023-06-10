import React from "react";
import { NavLink } from "react-router-dom";

const TransferButton = () => {
    return(
      
         <button className="inline-flex w-full items-center justify-center gap-x-1.5 rounded-md bg-newblue px-3 py-2 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-darkblue text-white font-semibold text-[1.4rem] w-full h-[5vh]">
            <NavLink to="/ReceiveTicket"> Recive Ticket</NavLink>
        </button>
       

    )
}

export default TransferButton;