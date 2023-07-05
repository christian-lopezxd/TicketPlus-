import React from "react";
import Footer from "../../Components/Admin/Footer/Footer";
import Navbar from "../../Components/Admin/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";
import CardContainerAdmin from "../../Components/Admin/CardContainer/CardContainer";

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
