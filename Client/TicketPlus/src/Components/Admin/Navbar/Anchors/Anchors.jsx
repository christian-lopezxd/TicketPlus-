import React from "react";

import { FiCalendar } from 'react-icons/fi';
import { FiUser } from 'react-icons/fi';
import { IoHomeOutline } from 'react-icons/io5';
import { NavLink } from "react-router-dom";


const Anchors = (props) => {
  return (

    <div className="text-white h-full flex text-3xl gap-2 px-1 sm:hidden items-center h-full ">
    <div className="flex flex-row gap-5 h-full">
    <NavLink to="/" className="flex items-center gap-1 hover:bg-black h-full px-3" title="Home">
        <IoHomeOutline className=" h-full"/>
      
       </NavLink>
      <NavLink to="/Events" className="flex items-center gap-1 hover:bg-black h-full px-3" title="Events">
      <FiCalendar className="hover:bg-black h-full" />
        
      </NavLink>
  
      <NavLink to={`/Profile/${props.id}`} className="flex items-center gap-1 hover:bg-black h-full p-3" title="My Profile">

      <FiUser />
      </NavLink>
    </div>
     
    </div>
  );
};

export default Anchors;