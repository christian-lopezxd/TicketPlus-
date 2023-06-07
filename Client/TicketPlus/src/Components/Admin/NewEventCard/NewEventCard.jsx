import React from "react";
import { ImCheckmark, ImCross } from 'react-icons/im';

const NewEvent = () => {
  return(
    <div>
      <form className="bg-white max-w-4xl mb-8  mx-auto p-6 rounded-b-2xl" action="">
        <div className=' grid grid-cols-2 md:grid-cols-1'>
          <div className="justify-items-start p-3" >
            <h2 className="font-bold text-3xl">New Event</h2>
            <input className="bg-selector rounded-md p-2 m-1 w-full" type="text" placeholder="Name"/>
            <input className="bg-selector rounded-md p-2 m-1 w-full" id='spot' placeholder="Spot" />
            <input className="bg-selector rounded-md p-2 m-1 w-full" id='type' placeholder="Type" />
            <label className="font-semibold" htmlFor="">Initial Date</label>
            <input 
              className="bg-selector rounded-md p-2 m-1 w-full"
              type="date" 
              id="initial-date"  
            />
            <label className="font-semibold" htmlFor="">Final Date</label>
            <input 
              className="bg-selector rounded-md p-2 m-1 w-full"
              type="date" 
              id="final-date"  
            />
            <label className="font-semibold" htmlFor="">Hour</label>
            <input className="bg-selector rounded-md p-2 m-1 w-full" type="time" name="Hour" id="hour" />
          </div>
          <div className="justify-items-start p-3">
            <h2 className="font-bold text-3xl scroll">Tiers</h2>
            <input className="bg-selector rounded-md p-2 m-1 w-full" id='tier' placeholder="Tier" />
            <label className="font-semibold" htmlFor="">Banner</label>
            <input className="bg-selector rounded-md p-2 m-1 w-full" type="file" accept="image/jpeg" />
            <label className="font-semibold" htmlFor="">Card</label>
            <input className="bg-selector rounded-md p-2 m-1 w-full" type="file" accept="image/jpeg" />
          </div>
        </div>
        <div className="w-full">  
          <div className="flex flex-wrap justify-end">
            <button className="flex flex-row items-center gap-2 bg-darkunsuccesful hover:bg-newpink py-2 px-4 mx-2 rounded font-montserrat text-white font-normal" ><ImCross/>Cancel</button>
            <button className="flex flex-row items-center gap-2 bg-newblue hover:bg-darkblue py-2 px-4 rounded mx-2 font-montserrat text-white font-normal"><ImCheckmark/>Create</button>
          </div>
        </div>
        </form>
    </div>
  )
}

export default NewEvent;