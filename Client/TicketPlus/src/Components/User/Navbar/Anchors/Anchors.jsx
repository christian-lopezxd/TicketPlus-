import React from "react";
import { FiUser } from 'react-icons/fi';
import { FiCalendar } from 'react-icons/fi';
import { FiAlertCircle } from 'react-icons/fi';
import { IoTicketOutline } from 'react-icons/io5';
import { NavLink } from "react-router-dom";


const Anchors = () => {
  return (
    <div className="text-white flex gap-3 p-1 sm:hidden items-center">
    <NavLink to="/About" className="flex items-center gap-1">
        <FiAlertCircle />
        About
       </NavLink>
      <NavLink to="/" className="flex items-center gap-1">
      <FiCalendar />
        Events
      </NavLink>
      <NavLink to="/MyTickets" className="flex items-center gap-1">
         <IoTicketOutline />
         MyTickets
      </NavLink>
      <NavLink to="/Profile" className="flex items-center gap-1">
      <FiUser />
        Profile
      </NavLink>
    </div>
  );
};

export default Anchors;