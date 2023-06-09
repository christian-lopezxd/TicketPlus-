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

const UserRouter = () => {
    return (
        <Routes>
            <Route path="/" element={<Lobby/>}></Route>
            <Route path="/Event" element={<EventInfo/>}></Route>
            <Route path="/MyTickets" element={<MyTickets/>}></Route>
            <Route path="/BuyTicket" element={<BuyTicket/>}></Route>
            <Route path="/ShareTicket" element={<ShareTicket/>}></Route>
            <Route path="/ScanShareTicket" element={<ScanShareTicket/>}></Route>
            <Route path="/ReceiveTicket" element={<ReceiveTicket/>}></Route>
            <Route path="/Redeem" element={<RedeemTicket/>}></Route>

        </Routes>
    )
}

export default UserRouter;