import React from "react";
import { IoLocationOutline } from 'react-icons/io5';
import { IoCalendarClearOutline } from 'react-icons/io5';
import { IoTicketOutline } from 'react-icons/io5';
import { FiClock } from 'react-icons/fi';
import { NavLink } from "react-router-dom";
const imageURL = "http://162.243.162.41/guest/event/picture/"


const Card = (props) => {
    return (
        <div className="bg-white flex  flex-col drop-shadow-2xl hover:scale-105 h-[35rem] sm:w-[40%] md:w-[50%] chibby:w-[100%]  w-[25%] md:h-auto rounded-lg justify-center ">
           <div className="w-[100%] h-[60%]">
           <img src={`${imageURL}${props.imagen}`} className="w-full h-full rounded-t-lg "/>
           </div>
            <h1 className="text-center font-montserrat font-normal text-lg p-1">{props.titulo}</h1>
            <hr/>
            <div className="px-3 py-1">
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"><IoLocationOutline/> {`${props.localizacion}, ${props.ciudad}`} </p>
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"> <IoCalendarClearOutline/> {props.fecha} </p>
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"><FiClock/> {props.horaEntrada} - {props.horaSalida}</p>
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"><IoTicketOutline/> {props.categoria}  </p>
            <div className="flex  p-2 items-center  md:flex-col w-full justify-between md:w-full md:gap-2">
              
           
           <NavLink to={`/Event/edit/${props.idEvent}`} className="w-[20%] md:w-full" ><button className="bg-newblue hover:bg-darkblue py-4 px-2 rounded font-montserrat text-white font-normal w-full md:py-2">edit</button></NavLink>
            <NavLink to={`/Event/addTiers/${props.idEvent}` } className=" md:w-full"><button className="bg-newblue hover:bg-darkblue py-4 px-2 rounded font-montserrat text-white font-normal w-full md:py-2">add tiers</button></NavLink>
            <NavLink className="w-[20%] md:w-full"><button className="bg-newblue hover:bg-darkblue py-4 px-2 rounded font-montserrat text-white font-normal w-full md:py-2">Activate</button></NavLink>
            <NavLink className="w-[20%] md:w-full"><button className="bg-newblue hover:bg-darkblue py-4 px-2 rounded font-montserrat text-white font-normal w-full md:py-2">Store</button></NavLink>

           
            </div>
            </div>

        </div>
    )
}

export default Card;