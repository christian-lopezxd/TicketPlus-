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
           <div className="flex xl:flex-col  justify-between md:items-center min-h-[85vh] xl:justify-start pt-5">
            <div className="w-[25vw] sm:w-full sm:justify-end sm:p-4 flex justify-center md:p-2 sm:w-100 py-5 pl-2 h-fit xl:static z-[1] sticky top-[75px] ">
               <MyTicketSelector/>

            </div>
           <div className="w-[75vw]  md:w-full md:items-center md:h-auto xl:w-100 pr-10 sm:pr-0 ">
           <BundleContainer  />
           </div>
           </div>
            <Footer />

        </section>
    )
}

export default MyTickets;