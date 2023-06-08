import React from "react";
import { FiUser } from 'react-icons/fi';
import { FiCalendar } from 'react-icons/fi';
import { FiAlertCircle } from 'react-icons/fi';
import { IoTicketOutline } from 'react-icons/io5';
import { NavLink } from "react-router-dom";


const Anchors = () => {
  return (
    <div className="text-white flex md:hidden items-center">
      <NavLink to="/About" className="mx-4 flex items-center gap-1 hover:text-darkwhite duration-500">
        <FiAlertCircle />
        About
       </NavLink>
      <NavLink to="/" className="mx-4 flex items-center gap-1 hover:text-darkwhite duration-500">
      <FiCalendar />
        Events
      </NavLink>
      <NavLink to="/MyTickets" className="mx-4 flex items-center gap-1 hover:text-darkwhite duration-500">
         <IoTicketOutline />
         MyTickets
      </NavLink>
      <NavLink to="/Profile" className="mx-4 flex items-center gap-1 hover:text-darkwhite duration-500">
      <FiUser />
        Profile
      </NavLink>
    </div>
  );
};

export default Anchors;