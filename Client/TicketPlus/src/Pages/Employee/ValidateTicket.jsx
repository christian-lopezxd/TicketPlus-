import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";
import ValidatorTicket from "../../Components/User/ValidatorTicket/ValidatorTicket";
import CountTicket from "../../Components/User/CountTicket/CountTicket";

const ValidateTicket = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">

      <Navbar />
      <Title title= "Ticket Validator" />
      <ValidatorTicket />
      <CountTicket />
      <Footer />
      
    </section>
  );
};

export default ValidateTicket;