import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import NoAuthLobby from './../Pages/NoAuth/NoAuthLobby';
import Login from './../Pages/NoAuth/Login';
import Register from "../Pages/NoAuth/Register";
import CheckEmail from "../Pages/NoAuth/CheckEmail";
import Verify from "../Pages/NoAuth/Verify";
import SuccessVerify from "../Pages/NoAuth/successVerify";
const AuthRouter = () =>{
    return (
        <Routes>
            <Route path="/" element={<NoAuthLobby/>}></Route>
            <Route path="/Login" element={<Login/>}></Route>
            <Route path="/Register" element={<Register/>}></Route>
            <Route path="/success" element={<CheckEmail />}></Route>
            <Route path="/verify/:UUID" element={<Verify />}></Route>
            <Route path="/verify/success" element={<SuccessVerify />}></Route>

        </Routes>
    )
}

export default AuthRouter;