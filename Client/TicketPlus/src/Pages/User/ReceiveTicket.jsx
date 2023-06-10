import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import QRRedeem from "../../Components/User/QRRedeem/QRRedeem";

const ReceiveTicket = () => {
    return(
        <section className="bg-backgroundicons bg-repeat ">
        <Navbar/>
        <QRRedeem title="Use this QR Code to receive your ticket" />
        <Footer />
    </section>
    )
}

export default ReceiveTicket;