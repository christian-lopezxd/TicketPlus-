import React from "react";
import arianabanner from "./../../../../assets/arianabanner.png";
import { IoLocationOutline } from "react-icons/io5";
import { IoCalendarClearOutline } from "react-icons/io5";
import { IoTicketOutline } from "react-icons/io5";
import { FiClock } from "react-icons/fi";



const TicketToTransfer = () =>{
    return(
        <div className=" flex flex-col group md:items-center h-full my-4">
      <div className="w-full h-[20rem] xl:h-[20rem] sm:h-[20rem]  sm:w-full md:max-w-[500px] md:h-auto flex flex-row md:flex-col pr-5 sm:pr-0 sm:pt-6  md:p-0 font-montserrat  ">
        <div className="w-3/4 sm:w-full  h-full rounded-2xl md:h-[10rem]  md:rounded-t-2x md:h-[50%] ">
          <img
            src={arianabanner}
            className=" object-fill   h-full rounded-2xl md:rounded-t-2xl md:rounded-b-none "
          />

         
        </div>

        {/*hover */}

        <div className="bg-selector md:justify-center  rounded-2xl flex flex-col p-5 md:rounded-b-2xl md:rounded-t-none ">
          <div className=" -rotate-90 md:-rotate-0 h-full flex flex-col gap-3 max-h-100% max-w-100%">
            <h1 className="text-center pt-4">
              This ticket is valid for one person only
            </h1>
            <ul className="font-semibold flex   text-xl md:text-md flex-col sm:gap-0 gap-2">
              <li>
                <p className="flex items-center  gap-2">
                  <IoLocationOutline />
                  Estadio Cuscatlan
                </p>
              </li>
              <li>
                <p className="flex items-center  gap-2">
                  <IoCalendarClearOutline />
                  28 de abril
                </p>
              </li>
              <li>
                <p className="flex items-center gap-2">
                  <FiClock />
                  hora
                </p>
              </li>
              <li>
                <p className="flex items-center  gap-2">
                  <IoTicketOutline />
                  concierto
                </p>
              </li>
              <li>
                <p className="flex items-center gap-2">
                  <IoTicketOutline />
                  Tier
                </p>
              </li>
            </ul>

           
            
          </div>
        </div>
      </div>
    </div>
    )
}

export default TicketToTransfer;