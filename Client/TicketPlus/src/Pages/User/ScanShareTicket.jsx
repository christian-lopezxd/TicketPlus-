import React from "react";
import ValidatorTicket from "../../Components/User/ValidatorTicket/ValidatorTicket";
import Navbar from "../../Components/User/Navbar/Navbar";
import Footer from "../../Components/User/Footer/Footer";

const ScanShareTicket = () =>  {
    return(
        <section className="bg-backgroundicons bg-repeat ">
            <Navbar/>
            <ValidatorTicket/>
            <Footer />
        </section>
    )
}

export default ScanShareTicket;