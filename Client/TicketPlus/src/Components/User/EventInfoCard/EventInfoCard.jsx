import React from "react";
import { IoLocationOutline } from 'react-icons/io5';
import { IoCalendarClearOutline } from 'react-icons/io5';
import { IoTicketOutline } from 'react-icons/io5';
import { FiClock } from 'react-icons/fi';
import { ImCross } from 'react-icons/im';
import { ImTicket } from 'react-icons/im';
import ButtonsDuo from "../ButtonsDuo/ButtonsDuo";

const EventInfoCard = (props) => {
  return (
    <div className=" flex flex-col w-3/4 h-1/2 bg-white m-auto text-justify p-5 font-montserrat font-medium">
      <h1 className="font-bold">Description</h1>
      <p className="w-4/5">{props.description}</p><br/>
      <h1 className="font-bold"> Details</h1>
      <ul>
        <li><p className="flex items-center text-lg gap-1"><IoLocationOutline/>{props.Location}</p></li> 
        <li><p className="flex items-center text-lg gap-1"><IoCalendarClearOutline/>{props.Date}</p></li>
        <li><p className="flex items-center text-lg gap-1"><FiClock/>{props.Hour}</p></li>
        <li><p className="flex items-center text-lg gap-1"><IoTicketOutline/>{props.Category}</p></li>
      </ul><br/>
    <h1 className="font-bold">Tiers</h1>
    <ul>
        <li>General</li>
        <li>Premium</li>
        <li>Platinum</li>
        <li>Vip</li>
    </ul>
    <ButtonsDuo denylogo={<ImCross/>} denymessege="Cancel" acceptmessege="Buy Tickets" acceptlogo={<ImTicket/>}/>
    </div>
  );
};

export default EventInfoCard;
