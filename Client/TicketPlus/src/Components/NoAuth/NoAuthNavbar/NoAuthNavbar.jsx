import React from "react";
import { NavLink } from "react-router-dom";
import LoginButton from "./LoginButton/LoginButton";

const NoAuthNavbar = () => {
  return (
    <div className="bg-grissoft h-20 flex justify-between p-2 items-center sticky top-0 z-50">
      <NavLink to="/"><p className="text-white font-lilita text-5xl">TicketPlus</p></NavLink>
      <LoginButton />
      
    </div>
  );
};

export default NoAuthNavbar;
