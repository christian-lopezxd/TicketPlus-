import React from "react";
import Footer from "../../Components/Analyst/Footer/Footer";
import Navbar from "../../Components/Analyst/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";
import CardContainer from "../../Components/Analyst/CardContainer/CardContainer";


const Lobby = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">
      <Navbar />
      <Title title="All Events" />
      <CardContainer />
      <Footer />
    </section>
  );
};

export default Lobby;
