import React from "react";
import NewEvent from "../../Components/User/NewEvent/NewEvent";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";


const EventInfoAdmin = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">

      <Navbar />
      <Title title= "New Event" />
      <NewEvent />
      <Footer />
      
    </section>
  );
};

export default EventInfoAdmin;