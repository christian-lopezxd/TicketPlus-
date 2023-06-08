import React from "react";
import { NavLink } from "react-router-dom";
import { BsQrCodeScan } from "react-icons/bs";
import TicketToTransfer from "./TicketToShare/TicketToTransfer";
import { ImCross } from 'react-icons/im';

const ShareTicketCard = () => {
    return(
        <div className="h-full py-3 max-w-[75vw] rounded-b-2xl mx-auto p-4 bg-white">
            <TicketToTransfer />  

            <div className=" flex flex-row justify-center gap-5 md:flex md:flex-col md:text-sm font-bold p-2">
              <button className="flex flex-row items-center gap-2  bg-unsuccesful md:justify-center hover:bg-darkunsuccesful py-4 px-4 rounded-2xl font-montserrat text-white font-semibold py-1 px-3 z-10 ">
                <NavLink to="/Redeem" className="flex items-center gap-2">
                <ImCross/> Cancel
                </NavLink>
              </button>
              <button className="flex flex-row items-center gap-2 bg-newblue md:justify-center hover:bg-darkblue py-4 px-4 rounded-2xl font-montserrat text-white font-semibold py-1 px-3 opacity-100 ">
                <NavLink to="/ShareTicket" className="flex items-center gap-2">
                  {" "}
                  <BsQrCodeScan />
                  Scan Transfer QR Code
                </NavLink>
              </button>
            </div>

        </div>

    )
}

export default ShareTicketCard;
