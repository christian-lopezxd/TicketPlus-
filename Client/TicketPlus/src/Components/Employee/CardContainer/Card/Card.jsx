import React from "react";
import ariana from "./../../../../assets/ariana.png";
import { IoLocationOutline } from "react-icons/io5";
import { IoCalendarClearOutline } from "react-icons/io5";
import { IoTicketOutline } from "react-icons/io5";
import { FiClock } from "react-icons/fi";
import { NavLink } from "react-router-dom";

const Card = () => {
  return (
    <div className="bg-white min-w-1/5 max-w-1/3 flex flex-col sm:max-w-full rounded-lg justify-center drop-shadow-2xl h-fit hover:scale-105">
      <img src={ariana} className="w-full  rounded-t-lg " />
      <h1 className="text-center font-montserrat font-normal text-lg p-1">
        Ariana Grande: Dangerous Woman Tour
      </h1>
      <hr />
      <div className="px-3 py-1">
        <p className="font-montserrat font-normal flex items-center text-lg gap-1">
          <IoLocationOutline /> Estadio Cuscatlan
        </p>
        <p className="font-montserrat font-normal flex items-center text-lg gap-1">
          {" "}
          <IoCalendarClearOutline />
          Friday, April 28th
        </p>
        <p className="font-montserrat font-normal flex items-center text-lg gap-1">
          <FiClock /> 7:00PM - 10:00PM
        </p>
        <p className="font-montserrat font-normal flex items-center text-lg gap-1">
          <IoTicketOutline /> Concert
        </p>
        <div className="flex flex-col p-2 items-center ">
          <NavLink to="/ValidateTicket">
            <button className="bg-newblue hover:bg-darkblue rounded font-montserrat text-white font-normal py-1 px-3">
              Check in
            </button>
          </NavLink>
        </div>
      </div>
    </div>
  );
};

export default Card;
