import React from "react";
import { FiUser } from 'react-icons/fi';
import { FiCalendar } from 'react-icons/fi';
import { FiAlertCircle } from 'react-icons/fi';
import { IoTicketOutline } from 'react-icons/io5';


const Anchors = () => {
  return (
    <div className="text-white flex gap-3 p-1 sm:hidden items-center">
      <a className="flex items-center gap-1">
        <FiAlertCircle />
        About
      </a>
      <a className="flex items-center gap-1">
  
        <FiCalendar />
        Events
      </a>
      <a className="flex items-center gap-1">
         <IoTicketOutline />
         MyTickets
      </a>
      <a className="flex items-center gap-1">
      <FiUser />
        Profile
      </a>
    </div>
  );
};

export default Anchors;
