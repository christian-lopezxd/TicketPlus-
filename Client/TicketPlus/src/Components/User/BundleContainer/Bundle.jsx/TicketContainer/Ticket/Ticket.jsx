import React from "react";
import arianabanner from "./../../../../../../assets/arianabanner.png";
import { IoLocationOutline } from "react-icons/io5";
import { IoCalendarClearOutline } from "react-icons/io5";
import { IoTicketOutline } from "react-icons/io5";
import { FiClock } from "react-icons/fi";
import { BsQrCodeScan } from "react-icons/bs";
import { FaShare } from "react-icons/fa";


const Ticket = () => {
  return (
    <div className=" flex flex-col group md:justify-center ">
      <div className="w-full h-[20rem] xl:h-[20rem] sm:h-[20rem]  sm:w-full md:max-w-[500px] md:h-auto flex flex-row md:flex-col pr-5 sm:pr-0 sm:pt-6  md:p-0 font-montserrat  ">
        <div className="w-3/4 sm:w-full  h-full rounded-2xl  md:rounded-t-2x relative md:h-[50%] ">
          <img
            src={arianabanner}
            className=" object-fill   h-full rounded-2xl md:rounded-t-2xl md:rounded-b-none "
          />

          <div className="w-[100%] h-full rounded-2xl top-0 absolute hidden group-hover:block md:group-hover:hidden overflow-hidden">
            <div className="w-full h-[20rem] xl:h-[20rem] sm:h-[20rem] bg-black sm:w-full md:h-[14rem] flex  rounded-2xl  opacity-50 flex-row pr-5 font-montserrat flex flex-row items-center justify-center gap-5 relative "></div>
            <div className=" flex flex-row items-center justify-center h-full w-full gap-2 absolute top-0">
              <button className="flex flex-row items-center gap-2 bg-newblue hover:bg-darkblue py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 z-10 ">
                <BsQrCodeScan/> Generate QR code
              </button>
              <button className="flex flex-row items-center gap-2 bg-unsuccesful hover:bg-darkunsuccesful py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 opacity-100 ">
                <FaShare/> Transfer Ticket
              </button>
            </div>
          </div>
        </div>

        {/*hover */}

        <div className="bg-white md:justify-center  rounded-2xl flex flex-col p-5 md:rounded-b-2xl md:rounded-t-none ">
          <div className=" -rotate-90 md:-rotate-0 h-full flex flex-col gap-3 max-h-100% max-w-100%">
            <h1 className="text-center">
              This ticket is valid for one person only
            </h1>
            <ul className="font-semibold flex   text-xl md:text-sm flex-col sm:gap-0 gap-2">
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
            <br />
            <div className="flex-row justify-center gap-5 hidden md:flex md:text-xs font-bold">
            <button className="flex flex-row items-center gap-2 bg-newblue hover:bg-darkblue py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 z-10 ">
            <BsQrCodeScan/> Generate QR code
              </button>
              <button className="flex flex-row items-center gap-2 bg-unsuccesful hover:bg-darkunsuccesful py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 opacity-100 ">
              <FaShare/> Transfer Ticket
              </button>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  );
};

export default Ticket;
