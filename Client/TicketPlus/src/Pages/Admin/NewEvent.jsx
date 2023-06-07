import React from "react";
import NewEventCard from "../../Components/Admin/NewEventCard/NewEventCard";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";


const NewEvent = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">

      <Navbar />
      <Title title= "New Event" />
      <NewEventCard />
      <Footer />
      
    </section>
  );
};

export default NewEvent;