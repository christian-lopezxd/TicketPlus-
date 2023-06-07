import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import LobbyEmployee from './../Pages/Employee/LobbyEmployee'
import EventInfoPreValidate from "../Pages/Employee/EventInfoPreValidate";
import ValidateTicket from "../Pages/Employee/ValidateTicket";

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