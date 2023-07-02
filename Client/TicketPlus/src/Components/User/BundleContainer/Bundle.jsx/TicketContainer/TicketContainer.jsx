import React from "react";
import Ticket from "./Ticket/Ticket";
import Events from "../../../../../Data/Events.json"



const TicketContainer = () => {
  return (
    
    <div className="p-3 flex flex-col gap-5 xl:w-[100vw] md:w-fit">
    {
     Events.map((evento)=> {
         const {id, banner} = evento
         return(
             <Ticket  id={id} imagen={banner} />
         )
     }
     )

    } 
    

     
 </div>
  );
};

export default TicketContainer;
