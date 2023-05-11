import React from "react";
import Footer from "../Components/User/Footer/Footer";
import Navbar from "../Components/User/Navbar/Navbar";
import Card from "../Components/User/Card/Card";

const Lobby = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">
      <Navbar />
      <div className="flex-grow h-screen">
      <Card />
      </div>
      <Footer />
    </section>
  );
};

export default Lobby;
