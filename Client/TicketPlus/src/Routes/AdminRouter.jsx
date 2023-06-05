
import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import LobbyAdmin from '../Pages/User/LobbyAdmin';
import EventInfoAdmin from '../Pages/User/EventInfoAdmin';
import NewEventAdmin from '../Pages/User/NewEventAdmin';

const AdminRouter = () =>{
    return (
        <Routes>
            <Route path="/" element={<LobbyAdmin/>}></Route>
            <Route path="/Event" element={<EventInfoAdmin/>}></Route>
            <Route path="/NewEvent" element={<NewEventAdmin/>}></Route>
        </Routes>
    )
}

export default AdminRouter;