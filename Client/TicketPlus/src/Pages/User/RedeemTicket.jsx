import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import QRRedeem from "../../Components/User/QRRedeem/QRRedeem";

const RedeemTicket = () =>{
    return(
        <section className="bg-backgroundicons bg-repeat ">
            <Navbar/>
            <QRRedeem title="Scan this QR to enter the event"/>
            <Footer />
        </section>
    )
}

export default RedeemTicket;