import React, { useState } from "react";
import { NavLink } from "react-router-dom";
import Anchors from "./Anchors/Anchors";
import { ImCross, ImMenu } from "react-icons/im";
import { FiUser } from 'react-icons/fi';
import { FiCalendar } from 'react-icons/fi';
import { FiAlertCircle } from 'react-icons/fi';
import { IoTicketOutline } from 'react-icons/io5';

const Navbar = () => {
  const [open, setOpen] = useState(false);  
  return (
    <nav className="bg-grissoft py-4 ">
      <div className="flex items-center justify-between">
        <div className="z-50 w-auto md:w-full flex md:items-center md:justify-between">
          <NavLink to="/"> <p className="text-white font-lilita text-5xl pl-4">Ticketplus</p> </NavLink >
          <button className="text-white text-3xl pr-4 hidden md:block" onClick={()=>setOpen(!open)}>{open ? <ImCross/> : <ImMenu/>}</button>
        </div>
        <div className={`bg-grissoft z-40 text-white hidden md:block md:absolute md:w-full md:h-full md:bottom-0 md:py-24 md:pl-10 duration-500 ${open ? 'right-0' : 'right-[-100%]'}`}>
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
          <NavLink to="/" className="mt-20   flex items-center gap-1 hover:text-darkwhite duration-500">
            Log off
          </NavLink>
        </div>
        <Anchors />
      </div>
    </nav>
  );
};

export default Navbar;
