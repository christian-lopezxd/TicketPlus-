import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";
import BundleContainer from "../../Components/User/BundleContainer/BundleContainer";
import MyTicketSelector from "../../Components/User/MyTicketController/MyTicketSelector";

const MyTickets = () => {
    return(
        <section className="bg-backgroundicons bg-repeat ">
            <Navbar/>
            <Title title="My Tickets"/>
           <div className="flex xl:flex-col  justify-between md:items-center min-h-[85vh] xl:justify-start">
            <div className="w-[25vw] md:w-full flex justify-center md:p-2 sm:w-100 py-5 pl-2 h-fit md:static z-[1] sticky top-[75px]">
               <MyTicketSelector/>

            </div>
           <div className="w-[75vw]  md:w-fit md:h-auto xl:w-100 pr-10 sm:pr-0 ">
           <BundleContainer />
           </div>
           </div>
            <Footer />

        </section>
    )
}

export default MyTickets;