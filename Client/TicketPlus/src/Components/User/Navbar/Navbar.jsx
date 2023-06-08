import React from "react";
import { NavLink } from "react-router-dom";
import Anchors from "./Anchors/Anchors";
import AnchorsMobile from "./Anchors/AnchorsMobile";

const Navbar = () => {
  return (
    <nav className="bg-grissoft p-5 flex items-center justify-between">
      <div>
        <NavLink to="/"> <p className="text-white font-lilita text-5xl">Ticketplus</p> </NavLink >
      </div>
      <div>
        <AnchorsMobile />
      </div>
      <div>
        <Anchors />
      </div>
    </nav>
  );
};

export default Navbar;
