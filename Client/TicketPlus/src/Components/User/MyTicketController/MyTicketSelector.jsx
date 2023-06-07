import React from "react";
import Dropdown from "./Dropdown/Dropdown";
import TransferButton from "./TransferButton/TransferButton";

const MyTicketSelector = () => {
    return(
        <div className="w-full gap-2 sm:w-[25%] chibby:w-full flex flex-col m-0 justify-center sm:items-end items-center">
            <TransferButton/>
            <Dropdown />

        </div>

    )
}

export default MyTicketSelector;
