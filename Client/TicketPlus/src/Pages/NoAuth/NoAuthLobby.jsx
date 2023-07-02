import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import CardContainer from "../../Components/User/CardContainer/CardContainer";
import Title from "../../Components/User/Title/Title";
import NoAuthNavbar from "../../Components/NoAuth/NoAuthNavbar/NoAuthNavbar";
const url = "./src/Data/Events.json";
import { useState } from "react";
import { useEffect } from "react";





const NoAuthLobby = () => {

  let [eventos, setEventos] = useState([1,2,3,4,5])


useEffect(() =>{
  let datos = async () => {
    const response = await fetch(url);
    const x = await response.json();
    setEventos(x)
  };

  datos()
  
  
}, [])

const title="Next Events"
  return (
    <section className="bg-backgroundicons bg-repeat">
      <NoAuthNavbar/>
      <Title title="Next Events"/>
      <CardContainer  Eventos = {eventos}/>
      <Footer />
    </section>
  );
};

export default NoAuthLobby;
