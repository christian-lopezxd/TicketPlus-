import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import CardContainer from "../../Components/User/CardContainer/CardContainer";
import Title from "../../Components/User/Title/Title";
import NoAuthNavbar from "../../Components/NoAuth/NoAuthNavbar/NoAuthNavbar";

const title="Next Events"


const NoAuthLobby = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">
      <NoAuthNavbar/>
      <Title title="Next Events"/>
      <CardContainer />
      <Footer />
    </section>
  );
};

export default NoAuthLobby;
