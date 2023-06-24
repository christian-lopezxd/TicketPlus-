
import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import LobbyAdmin from '../Pages/Admin/Lobby';
import NewEvent from '../Pages/Admin/NewEvent';
import Profile from "../Pages/User/Profile";
import EventInfo from "../Pages/User/EventInfo";

const AdminRouter = () =>{
    return (
        <Routes>
            <Route path="/" element={<LobbyAdmin/>}></Route>
            <Route path="/NewEvent" element={<NewEvent/>}></Route>
            <Route path="/Profile" element={<Profile />}></Route>
            <Route path="/Event" element={<EventInfo/>}></Route>

        </Routes>
    )
}

export default AdminRouter;