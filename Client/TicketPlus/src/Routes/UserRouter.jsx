import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import Lobby from './../Pages/User/Lobby'
import EventInfo from './../Pages/User/EventInfo'

const UserRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<Lobby/>}></Route>
            <Route path="/Event" element={<EventInfo/>}></Route>
            <Route path="/MyTickets" element={<EventInfo/>}></Route>

        </Routes>
    )
}

export default UserRouter;