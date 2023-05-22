import React from "react";
import arianabanner from './../../../../../../assets/arianabanner.png';

const Ticket = () => {
    return(
        <div className="w-full h-[35vh] flex flex-row pr-5">
            <div className="w-3/4 h-full rounded-2xl">
            <img src={arianabanner} className="w-1/2 object-fill w-full  h-full rounded-2xl"/>
            </div>
            <div className="bg-white w-1/3 rounded-2xl">
                <h1>sexo</h1>


            </div>

        </div>
    )
}

export default Ticket; 