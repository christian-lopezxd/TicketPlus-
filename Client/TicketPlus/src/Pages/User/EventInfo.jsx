import React from "react";
import Banner from "../../Components/User/Banner/Banner";
import EventInfoCard from "../../Components/User/EventInfoCard/EventInfoCard";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";
import { useParams } from "react-router-dom";



const EventInfo = () => {
  const params = useParams();
  return (
    <section className="bg-backgroundicons bg-repeat">

      <Navbar />
      <Banner/>
      <Title title= "Ariana grande: Dangerous Woman Tour" />
      <EventInfoCard description="Lorem ipsum dolor sit amet consectetur adipisicing elit. Quaerat, minus aspernatur aut est aliquid itaque ex nihil. Voluptatibus numquam porro voluptas quo molestiae perspiciatis, doloremque at ducimus modi sit vitae. Praesentium perferendis aut mollitia non reprehenderit, possimus aliquid quasi ut velit sed aperiam, molestiae earum consectetur suscipit provident. Impedit, quam!" 
        id="1"
        Location= "Estadio Cuscatlan" 
        Date="Friday, April 28th"
        Hour="7:00 PM" 
        Category="Concert"/>
      <Footer />
      
    </section>
  );
};

export default EventInfo;
