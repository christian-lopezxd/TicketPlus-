import React from "react";
import { Routes } from "react-router";
import { Route } from "react-router";
import Lobby from './../Pages/User/Lobby'
import EventInfo from './../Pages/User/EventInfo'
import BuyTicket from "../Pages/User/BuyTicket";
import MyTickets from "../Pages/User/MyTickets";
import RedeemTicket from "../Pages/User/RedeemTicket";
import ShareTicket from "../Pages/User/ShareTicket";
import ReceiveTicket from "../Pages/User/ReceiveTicket";
import ScanShareTicket from "../Pages/User/ScanShareTicket";
import Profile from "../Pages/User/Profile";

const UserRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<Lobby/>}></Route>
            <Route path="/Events" element={<EventInfo/>}></Route>
            <Route path="/Event/:id" element={<EventInfo />}></Route>
            <Route path="/MyTickets" element={<MyTickets/>}></Route>
            <Route path="/BuyTicket/:id" element={<BuyTicket/>}></Route>
            <Route path="/ShareTicket/:id" element={<ShareTicket/>}></Route>
            <Route path="/ScanShareTicket/:id" element={<ScanShareTicket/>}></Route>
            <Route path="/ReceiveTicket" element={<ReceiveTicket/>}></Route>
            <Route path="/Redeem/:id" element={<RedeemTicket/>}></Route>
            <Route path="/Profile/:id" element={<Profile />}></Route>

        </Routes>
    )
}

export default UserRouter;