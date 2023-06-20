import React from "react";
import Banner from "../../Components/User/Banner/Banner";
import StatsContainer from "../../Components/Analyst/StatsContainer/StatsContainer";
import Footer from "../../Components/Analyst/Footer/Footer";
import Navbar from "../../Components/Analyst/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";


const EventStats = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">

      <Navbar />
      <Banner/>
      <Title title= "Ariana grande: Dangerous Woman Tour" />
      <StatsContainer />
      <Footer />
      
    </section>
  );
};

export default EventStats;