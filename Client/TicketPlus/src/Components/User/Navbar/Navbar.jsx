import React, { useState } from "react";
import { NavLink } from "react-router-dom";
import Anchors from "./Anchors/Anchors";



const Navbar = () => {
 
  return (

    <div className="bg-grissoft h-20 flex justify-between px-2 items-center sticky top-[0] z-[99]">
      <NavLink to="/"> <p className="text-white font-lilita text-5xl">Ticketplus</p> </NavLink >

      <Anchors />

     
    </div>

  );
};

export default Navbar;
