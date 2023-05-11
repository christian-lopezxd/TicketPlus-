import React from "react";
import ariana from './../../../../assets/ariana.png';
import { IoLocationOutline } from 'react-icons/io5';
import { IoCalendarClearOutline } from 'react-icons/io5';

const Card = () => {
    return (
        <div className="bg-white min-w-1/5 max-w-1/3 flex flex-col sm:max-w-full rounded-lg justify-center">
            <img src={ariana} className="w-full  rounded-lg "/>
            <h1 className="text-center font-montserrat font-normal text-lg p-1">Ariana Grande: Dangerous Woman Tour</h1>
            <hr/>
            <div className="px-3 py-1">
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"><IoLocationOutline/> Estadio Cuscatlan</p>
            <p className="font-montserrat font-normal flex items-center text-lg gap-1"> <IoCalendarClearOutline/>Friday, April 28th</p>
            <p className="font-montserrat font-normal flex items-center text-lg gap-1">7:00PM - 10:00PM</p>
            <p className="font-montserrat font-normal flex items-center text-lg gap-1">Concert</p>

            </div>

        </div>
    )
}

export default Card;