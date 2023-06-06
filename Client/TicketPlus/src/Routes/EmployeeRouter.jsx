import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import LobbyEmployee from './../Pages/User/LobbyEmployee'
import EventInfoPreValidate from "../Pages/User/EventInfoPreValidate";
import ValidateTicket from "../Pages/User/ValidateTicket";

const EmployeeRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<LobbyEmployee/>}></Route>
            <Route path="/Event" element={<EventInfoPreValidate/>}></Route>
            <Route path="/ValidateTicket" element={<ValidateTicket/>}></Route>

        </Routes>
    )
}

export default EmployeeRouter;