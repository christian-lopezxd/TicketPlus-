import React from "react";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import ShareTicketCard from "../../Components/User/ShareTicketCard/ShareTicketCard";

import Title from "../../Components/User/Title/Title";

const ShareTicket = () => {
  return (
    <section className="bg-backgroundicons bg-repeat ">
      <Navbar />
      <Title title="Next Events" />
      <div className="min-h-[85vh]"><ShareTicketCard /></div>
      <Footer />
    </section>
  );
};

export default ShareTicket;
