import React from "react";
import { FiUser } from 'react-icons/fi';
import { FiCalendar } from 'react-icons/fi';
import { FiAlertCircle } from 'react-icons/fi';
import { IoTicketOutline } from 'react-icons/io5';
import { NavLink } from "react-router-dom";


const Anchors = () => {
  return (
    <div className="text-white flex gap-3 p-1 sm:hidden items-center">
    <NavLink to="/About"><a className="flex items-center gap-1">
        <FiAlertCircle />
        About
      </a> </NavLink>
      <NavLink to="/"><a className="flex items-center gap-1">
      <FiCalendar />
        Events
      </a></NavLink>
      <NavLink to="/MyTickets"><a className="flex items-center gap-1">
         <IoTicketOutline />
         MyTickets
      </a></NavLink>
      <NavLink to="/Profile"> <a className="flex items-center gap-1">
      <FiUser />
        Profile
      </a></NavLink>
    </div>
  );
};

export default Anchors;
