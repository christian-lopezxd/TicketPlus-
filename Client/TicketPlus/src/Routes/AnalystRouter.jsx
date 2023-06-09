import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import Lobby from './../Pages/Analyst/Lobby'
import EventInfo from './../Pages/Analyst/EventInfo'

const AnalystRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<Lobby/>}></Route>
            <Route path="/Event" element={<EventInfo/>}></Route>

        </Routes>
    )
}

export default AnalystRouter;