import React from "react";
import Footer from "../../Components/Admin/Footer/Footer";
import Navbar from "../../Components/Admin/Navbar/Navbar";
import CardContainer from "../../Components/Admin/CardContainer/CardContainer";
import Title from "../../Components/User/Title/Title";

const LobbyAdmin = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">
      <Navbar />
      <Title title="All Events" />
      <CardContainer />
      <Footer />
    </section>
  );
};

export default LobbyAdmin;
