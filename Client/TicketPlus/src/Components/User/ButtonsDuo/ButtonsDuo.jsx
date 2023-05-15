import React from "react";

const ButtonsDuo = (props) => {
    return(
        <div className="flex justify-end gap-2">
            <button className=" flex flex-row items-center gap-2 bg-unsuccesful hover:bg-darkunsuccesful py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 ">{props.denylogo}{props.denymessege}</button>
            <button className="flex flex-row items-center gap-2 bg-newblue hover:bg-darkblue py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 ">{props.acceptlogo}{props.acceptmessege}</button>
            
        </div>
    )

}

export default ButtonsDuo;