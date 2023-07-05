import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import CardContainer from "../../Components/User/CardContainer/CardContainer";
import Title from "../../Components/User/Title/Title";
import Carrousel from "../../Components/User/Carrousel/Carrousel";
import { useState } from "react";
import { useEffect } from "react";



const Lobby = () => {
  


  
  

  
  


  return (
    <section className="bg-backgroundicons bg-repeat">
      <Navbar />
      <Carrousel  />
      <Title title="Next Events" />
      <CardContainer  />
      <Footer />
    </section>
  );
};

export default Lobby;
