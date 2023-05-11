import React from "react";
import Footer from "../Components/User/Footer/Footer";
import Navbar from "../Components/User/Navbar/Navbar";
import CardContainer from "../Components/User/CardContainer/CardContainer";

const Lobby = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">
      <Navbar />
      
      <CardContainer />
      
      <Footer />
    </section>
  );
};

export default Lobby;
