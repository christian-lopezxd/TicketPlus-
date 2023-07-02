import React from "react";
import Swal from 'sweetalert2';
import { IoLocationOutline } from 'react-icons/io5';
import { IoCalendarClearOutline } from 'react-icons/io5';
import { IoTicketOutline } from 'react-icons/io5';
import { FiClock } from 'react-icons/fi';
import { ImCross } from 'react-icons/im';
import { ImTicket } from 'react-icons/im';
import TicketSelector from "./TicketSelector/TicketSelector";
import { NavLink } from "react-router-dom";



const BuyTicketCard = (props) => {

  const handleConfirm = () => {
   
    window.location.href = '/MyTickets';
  };

  const verify = () =>{
    Swal.fire({
      icon: 'question',
      iconColor: '4064E3',
      title: 'Do you want to make this purchase?',
      showDenyButton: true,
      confirmButtonText: "Buy",
      denyButtonText: "Cancel",
      denyButtonColor: '#DD1717',
      confirmButtonColor: '#4064E3'
      


    }).then(Response => {
      if(Response.isConfirmed){
        Swal.fire({
          icon: 'success',
          iconColor: '#4064E3',
          title: 'Tickets agregados a tu cuenta',
          confirmButtonAriaLabel: 'ta bueno',
          confirmButtonColor: '#4064E3',
          
        }
        ).then((result) => {
          if (result.isConfirmed) {
            // Llamar a la función handleConfirm cuando se confirme
            handleConfirm();
          }
        });
        
      }
    },
    
    )
  };

    return(
        <div className=" flex flex-col w-3/4 h-1/2 bg-white mx-auto my-10 text-justify p-5 font-montserrat font-medium rounded-xl">
       <div className="flex gap-2 my-5  xl:flex-col">
       <div className="w-1/2 xl:w-full"> 
        <h1 className="font-bold text-2xl p-2">Description</h1>
        <p className="p-2">{props.description}</p><br/>
        <h1 className="font-bold text-2xl p-2"> Details</h1>
        <ul>
          <li><p className="flex items-center text-lg gap-1 px-2"><IoLocationOutline/>{props.Location}</p></li> 
          <li><p className="flex items-center text-lg gap-1 px-2"><IoCalendarClearOutline/>{props.Date}</p></li>
          <li><p className="flex items-center text-lg gap-1 px-2"><FiClock/>{props.Hour}</p></li>
          <li><p className="flex items-center text-lg gap-1 px-2"><IoTicketOutline/>{props.Category}</p></li>
        </ul><br/>
        </div>
        <TicketSelector />
       </div> 
       <div className="flex justify-end">
       <div className=" flex flex-col justify-end w-1/2  xl:w-full justify-end">
          <h1 className="font-bold text-2xl">Recomendation</h1>
          <p className="p-2">{props.description}</p><br/>


          </div>
       </div>
      
      <div className="flex justify-end gap-2" >
             <NavLink to={`/Event/${props.id}`}> <button className=" flex flex-row items-center gap-2 bg-unsuccesful hover:bg-darkunsuccesful py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 "><ImCross/>Cancel</button> </NavLink>
              <button onClick={verify} className="flex flex-row items-center gap-2 bg-newblue hover:bg-darkblue py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 "><ImTicket />Buy</button>
              
          </div>
      </div>
    )
}

export default BuyTicketCard;