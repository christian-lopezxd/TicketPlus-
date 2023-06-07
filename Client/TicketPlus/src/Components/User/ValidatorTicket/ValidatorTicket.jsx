import React from "react";
import { ImCheckmark, ImCross } from 'react-icons/im';

const ValidatorTicket = () => {
  return(
    <div className="bg-grissoft max-w-4xl mb-2  mx-auto p-6 rounded-b-2xl">
      <div>
        <h1 className="flex flex-wrap justify-end text-white text-4xl">0/900</h1>
      </div>
      <div className="flex flex-col p-2 items-center">
        <h2 className="text-white font-semibold text-lg p-3">Scan the Qr</h2>
        <div className="bg-softblack p-32 rounded-xl">
          
        </div>
      </div>
      <div className="flex flex-wrap justify-end">
      <button className=" flex flex-row items-center gap-2 bg-unsuccesful hover:bg-darkunsuccesful rounded font-montserrat text-white font-normal py-2 px-4 "><ImCross/>Cancel</button>
      </div>
    </div>

  )
}

export default ValidatorTicket;