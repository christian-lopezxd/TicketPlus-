import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import LobbyEmployee from './../Pages/User/LobbyEmployee'
import EventInfo from './../Pages/User/EventInfo'

const EmployeeRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<LobbyEmployee/>}></Route>
            <Route path="/Event" element={<EventInfo/>}></Route>

        </Routes>
    )
}

export default EmployeeRouter;