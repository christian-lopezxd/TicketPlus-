import React from "react";

const CountTicket = () => {
  return(
    <div className="bg-grissoft max-w-4xl mb-8  mx-auto p-4 rounded-2xl flex flex-wrap justify-start">
      <div className="flex flex-col p-2 mx-3 items-center text-white">
        <ul>
          <li><p className="flex items-center text-lg gap-1">Tier: ----</p></li> 
          <li><p className="flex items-center text-lg gap-1">User Name: ----</p></li>
          <li><p className="flex items-center text-lg gap-1">Check in time: ----</p></li>
        </ul> 
      </div>
    </div>

  )
}

export default CountTicket;