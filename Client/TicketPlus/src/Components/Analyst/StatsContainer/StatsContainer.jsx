import React from "react";
import { ImCross } from 'react-icons/im';
import BarsChart from "./BarsChart/BarsChart";
import PiesChart from "./BarsChart/PiesChart";

const ValidatorTicket = () => {
  return(
    <div className="bg-white max-w-6xl mb-2 mx-auto p-6 rounded-b-2xl">
      <div className="flex flex-wrap justify-center py-6">
        <div>
          <BarsChart />
        </div>
        <div>
          <PiesChart />  
        </div>
      </div>
      <div className="flex flex-wrap justify-end">
      <button className=" flex flex-row items-center gap-2 bg-unsuccesful hover:bg-darkunsuccesful rounded font-montserrat text-white font-normal py-2 px-4 "><ImCross/>Cancel</button>
      </div>
    </div>
  )
}

export default ValidatorTicket;