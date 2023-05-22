import React from "react";
import Banner from "../../Components/User/Banner/Banner";
import BuyTicketCard from "../../Components/User/BuyTicketCard/BuyTicketCard";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";


const BuyTicket = () => {
  return (
    <section className="bg-backgroundicons bg-repeat ">

      <Navbar />
      <Banner/>
      <Title title= "Ariana grande: Dangerous Woman Tour" />
      <BuyTicketCard description="Lorem ipsum dolor sit amet consectetur adipisicing elit. Quaerat, minus aspernatur aut est aliquid itaque ex nihil. Voluptatibus numquam porro voluptas quo molestiae perspiciatis, doloremque at ducimus modi sit vitae. Praesentium perferendis aut mollitia non reprehenderit, possimus aliquid quasi ut velit sed aperiam, molestiae earum consectetur suscipit provident. Impedit, quam!" 
        Location= "Estadio Cuscatlan" 
        Date="Friday, April 28th"
        Hour="7:00 PM" 
        Category="Concert"/>
      <Footer />
      
    </section>
  );
};

export default BuyTicket;
