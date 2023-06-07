import React from "react";
import Card from "./Card/Card";
import { ImPlus } from "react-icons/im";
import { NavLink } from "react-router-dom";

const CardContainerAdmin = () => {
  return (
    <div className="py-6 flex flex-wrap justify-center">
      <NavLink to="/NewEvent">
        <button className="flex flex-row items-center gap-2 bg-newblue hover:bg-darkblue py-2 px-4 rounded mx-2 font-montserrat text-white font-normal">
          <ImPlus />
          Create New Event
        </button>
      </NavLink>
      <div className="flex flex-wrap gap-10 justify-center p-5">
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        
      </div>
    </div>
  );
};
export default CardContainerAdmin;
