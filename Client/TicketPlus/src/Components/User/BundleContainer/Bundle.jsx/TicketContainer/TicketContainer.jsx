import React from "react";
import Ticket from "./Ticket/Ticket";

const TicketContainer = () => {
    return(
        <div className="p-3 flex flex-col gap-5">
            <Ticket />
            <Ticket />
            <Ticket />
            <Ticket />
            <Ticket />
 
        </div>
    )
}

export default TicketContainer;