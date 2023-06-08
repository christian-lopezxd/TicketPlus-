import React, { useState } from "react";
import { NavLink } from "react-router-dom";
import Anchors from "./Anchors/Anchors";
import AnchorsMobile from "./Anchors/AnchorsMobile";
import { ImCross, ImMenu } from "react-icons/im";

const Navbar = () => {
  const [open, setOpen] = useState(false);  
  const menuClick = () =>{
    setOpen(!open);
  };
  return (
    <nav className="bg-grissoft py-4 ">
      <div className="flex items-center justify-between">
        <div className="z-50 w-auto md:w-full flex md:items-center md:justify-between">
          <NavLink to="/"> <p className="text-white font-lilita text-5xl pl-4">Ticketplus</p> </NavLink >
          <button className="text-white text-3xl pr-4 hidden md:block" onClick={()=>setOpen(!open)}>{open ? <ImCross /> : <ImMenu />}</button>
        </div>
        <AnchorsMobile onClick={menuClick} className={`transform duration-500 ${open ? "-translate-x-full" : "translate-x-0"}`}/>
        <Anchors />
      </div>
    </nav>
  );
};

export default Navbar;
