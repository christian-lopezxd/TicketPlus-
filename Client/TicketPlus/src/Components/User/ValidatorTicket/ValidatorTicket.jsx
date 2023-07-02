import React from "react";
import { ImCheckmark, ImCross } from 'react-icons/im';
import Test from "./QRReader/QRReader";
import QRCode from "react-qr-code";
import { NavLink } from "react-router-dom";

const ValidatorTicket = (props) => {
  return(
   <div className="h-[92vh] flex items-center justify-center w-full">
     <div className="bg-grissoft w-1/2 mb-2  p-6 rounded-2xl">
      <div>
        <h1 className="flex flex-wrap justify-end text-white text-4xl">0/900</h1>
      </div>
      <div className="flex flex-col p-2 items-center">
        <h2 className="text-white font-semibold text-2xl p-3">Scan the Qr</h2>
        <div className="bg-softblack h-[400px] w-[400px] rounded-xl">
          <Test />
        </div>

       
      </div>
      <div className="flex flex-wrap justify-end">
      <NavLink to={`/ShareTicket/${props.id}`}>
      <button className=" flex flex-row items-center gap-2 bg-unsuccesful hover:bg-darkunsuccesful rounded font-montserrat text-white font-normal py-2 px-4 ">
         <ImCross/>Cancel
        </button></NavLink>
      </div>
    </div>
   </div>

  )
}

export default ValidatorTicket;