import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import LobbyEmployee from './../Pages/Employee/LobbyEmployee'
import EventInfoPreValidate from "../Pages/Employee/EventInfoPreValidate";
import ValidateTicket from "../Pages/Employee/ValidateTicket";
import Profile from "../Pages/User/Profile";
const EmployeeRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<LobbyEmployee/>}></Route>
            <Route path="/Event/:id" element={<EventInfoPreValidate/>}></Route>
            <Route path="/ValidateTicket" element={<ValidateTicket/>}></Route>
            <Route path="/Profile" element={<Profile />}></Route>
        </Routes>
    )
}

export default EmployeeRouter;