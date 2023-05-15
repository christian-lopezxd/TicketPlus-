import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import NoAuthLobby from './../Pages/NoAuth/NoAuthLobby';
import Login from './../Pages/NoAuth/Login';
const AuthRouter = () =>{
    return (
        <Routes>
            <Route path="/" element={<NoAuthLobby/>}></Route>
            <Route path="/Login" element={<Login/>}></Route>

        </Routes>
    )
}

export default AuthRouter;