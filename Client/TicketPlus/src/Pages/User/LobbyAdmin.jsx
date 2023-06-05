import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import CardContainerAdmin from "../../Components/User/CardContainer/CardContainerAdmin";
import Title from "../../Components/User/Title/Title";

const LobbyAdmin = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">
      <Navbar />
      <Title title="All Events" />
      <CardContainerAdmin />
      <Footer />
    </section>
  );
};

export default LobbyAdmin;