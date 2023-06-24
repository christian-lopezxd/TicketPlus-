import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import Lobby from './../Pages/Analyst/Lobby'
import EventInfo from './../Pages/Analyst/EventInfo'
import EventStats from "../Pages/Analyst/EventStats";
import Profile from "../Pages/User/Profile";
import MyTickets from "../Pages/User/MyTickets";

const AnalystRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<Lobby/>}></Route>
            <Route path="/Event" element={<EventInfo/>}></Route>
            <Route path="/MyTickets" element={<MyTickets/>}></Route>
            <Route path="/EventStats" element={<EventStats/>}></Route>
            <Route path="/Profile" element={<Profile />}></Route>
        </Routes>
    )
}

export default AnalystRouter;