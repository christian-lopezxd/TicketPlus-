import React from "react";
import Dropdown from "./Dropdown/Dropdown";
import TransferButton from "./TransferButton/TransferButton";

const MyTicketSelector = () => {
    return(
        <div className="w-full gap-2 md:w-fit flex flex-col m-0 justify-center items-center">
            <TransferButton/>
            <Dropdown />

        </div>

    )
}

export default MyTicketSelector;
