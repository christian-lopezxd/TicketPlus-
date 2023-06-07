
import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import LobbyAdmin from '../Pages/Admin/Lobby';
import NewEvent from '../Pages/Admin/NewEvent';

const AdminRouter = () =>{
    return (
        <Routes>
            <Route path="/" element={<LobbyAdmin/>}></Route>
            <Route path="/NewEvent" element={<NewEvent/>}></Route>
        </Routes>
    )
}

export default AdminRouter;