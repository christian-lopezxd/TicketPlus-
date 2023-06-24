import React from "react";
import { IoLocationOutline } from 'react-icons/io5';
import { IoCalendarClearOutline } from 'react-icons/io5';
import { IoTicketOutline } from 'react-icons/io5';
import { FiClock } from 'react-icons/fi';
import { NavLink } from "react-router-dom";


const Card = (props) => {
    return (
        <div className="bg-white flex  flex-col drop-shadow-2xl hover:scale-105 h-[35rem] sm:w-[40%] md:w-[50%] chibby:w-[100%]  w-[25%]    rounded-lg justify-center ">
           <div className="w-[100%] h-[60%]">
           <img src={props.imagen} className="w-full h-full rounded-t-lg "/>
           </div>
            <h1 className="text-center font-montserrat font-normal text-lg p-1">{props.titulo}</h1>
            <hr/>
            <div className="px-3 py-1">
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"><IoLocationOutline/> {props.localizacion} </p>
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"> <IoCalendarClearOutline/> {props.fecha} </p>
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"><FiClock/> {props.horaEntrada} - {props.horaSalida}</p>
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"><IoTicketOutline/> {props.categoria}  </p>
            <div className="flex flex-col p-2 items-center ">
            <NavLink to={`/Event:${props.id}`}><button className="bg-newblue hover:bg-darkblue py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3">View More</button></NavLink>

            </div>
            </div>

        </div>
    )
}

export default Card;