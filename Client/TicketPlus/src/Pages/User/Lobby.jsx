import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import CardContainer from "../../Components/User/CardContainer/CardContainer";
import Title from "../../Components/User/Title/Title";
import Carrousel from "../../Components/User/Carrousel/Carrousel";
import { useState } from "react";
import { useEffect } from "react";
import Swal from 'sweetalert2'

const Lobby = () => {
  const url = "./src/Data/Events.json";


  let [eventos, setEventos] = useState([1,2,3,4,5])


  useEffect(() =>{
    let datos = async () => {
      const response = await fetch(url);
      const x = await response.json();
      setEventos(x)
    };

    datos()
    
    
  }, [])
  console.log(eventos)

  const verify = () =>{
    Swal.fire(
      'Good job!',
      'You clicked the button!',
      'success'
    )
  };
  
  


  return (
    <section className="bg-backgroundicons bg-repeat">
      <Navbar />
      <Carrousel Eventos = {eventos} />
      <button onClick={verify}>hola como estas</button>
      <Title title="Next Events" />
      <CardContainer Eventos = {eventos} />
      <Footer />
    </section>
  );
};

export default Lobby;
