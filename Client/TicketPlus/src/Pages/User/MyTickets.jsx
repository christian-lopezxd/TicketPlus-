import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";
import BundleContainer from "../../Components/User/BundleContainer/BundleContainer";

const MyTickets = () => {
    return(
        <section className="bg-backgroundicons bg-repeat ">
            <Navbar/>
            <Title title="My Tickets"/>
           <div className="flex">
            <div className="w-[25vw]">
                <h1>hola</h1>

            </div>
           <div className="w-[70vw]">
           <BundleContainer />
           </div>
           </div>
            <Footer />

        </section>
    )
}

export default MyTickets;