import React from "react";
import { IoLocationOutline } from 'react-icons/io5';
import { IoCalendarClearOutline } from 'react-icons/io5';
import { IoTicketOutline } from 'react-icons/io5';
import { FiClock } from 'react-icons/fi';
import { ImCross } from 'react-icons/im';
import { ImTicket } from 'react-icons/im';
import { NavLink } from "react-router-dom";


const EventInfoCard = (props) => {
  return (
    <div className=" flex flex-col w-3/4 h-1/2 bg-white mx-auto my-10 text-justify p-5 font-montserrat font-medium rounded-xl">
      <h1 className="font-bold text-2xl">Description</h1>
      <p className="w-full">{props.description}</p><br/>
      <h1 className="font-bold text-2xl"> Details</h1>
      <ul>
        <li><p className="flex items-center text-lg gap-1"><IoLocationOutline/>{props.Location}</p></li> 
        <li><p className="flex items-center text-lg gap-1"><IoCalendarClearOutline/>{props.Date}</p></li>
        <li><p className="flex items-center text-lg gap-1"><FiClock/>{props.Hour}</p></li>
        <li><p className="flex items-center text-lg gap-1"><IoTicketOutline/>{props.Category}</p></li>
      </ul><br/>
 
    
      <div className="flex justify-end gap-2">
        <NavLink to="/BuyTicket"> <button className="flex flex-row items-center gap-2 bg-newblue hover:bg-darkblue rounded font-montserrat text-white font-normal py-2 px-4 ">View Stats</button> </NavLink>
      </div>
    </div>
  );
};

export default EventInfoCard;
