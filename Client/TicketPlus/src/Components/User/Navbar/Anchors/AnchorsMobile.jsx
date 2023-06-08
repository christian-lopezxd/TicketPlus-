import React from "react";
import { FiUser } from 'react-icons/fi';
import { FiCalendar } from 'react-icons/fi';
import { FiAlertCircle } from 'react-icons/fi';
import { IoTicketOutline } from 'react-icons/io5';
import { NavLink } from "react-router-dom";


const Anchors = () => {
  return (
    <div className={`bg-grissoft z-40 text-white hidden md:block md:absolute md:w-full md:h-full md:bottom-0 md:py-24 md:pl-10`}>
      <NavLink to="/About" className="my-7 flex items-center gap-1 hover:text-darkwhite duration-500">
        <FiAlertCircle />
        About
       </NavLink>
      <NavLink to="/" className="my-7 flex items-center gap-1 hover:text-darkwhite duration-500">
      <FiCalendar />
        Events
      </NavLink>
      <NavLink to="/MyTickets" className="my-7 flex items-center gap-1 hover:text-darkwhite duration-500">
         <IoTicketOutline />
         MyTickets
      </NavLink>
      <NavLink to="/Profile" className="my-7 flex items-center gap-1 hover:text-darkwhite duration-500">
      <FiUser />
        Profile
      </NavLink>
    </div>
  );
};

export default Anchors;