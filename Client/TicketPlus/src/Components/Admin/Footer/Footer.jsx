import React from "react";
import Anchors from "../Navbar/Anchors/Anchors";
import { FaFacebookSquare } from 'react-icons/fa';
import { FaInstagram } from 'react-icons/fa';
import { FaTwitterSquare } from 'react-icons/fa';


const Footer = () => {
  return (
    <footer className="bg-grissoft text-white ">
    <div className="flex items-center justify-between p-4"> 
    <h1 className="font-lilita text-2xl">TicketPlus+</h1>
    <Anchors />
    </div>
    <div className="flex items-center  sm:flex-col justify-between p-4">
      <h5 className="max-w-sm text-justify">
        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Dolorem, molestiae assumenda minus praesentium laboriosam quis tenetur porro corrupti fuga, unde quo. Maiores iste obcaecati soluta quod rem sequi debitis expedita, est veniam at architecto nesciunt? Pariatur quos, quibusdam nesciunt, ducimus, repudiandae error sapiente at veniam hic odio eos laboriosam nemo?
      </h5>
    
      <div className="flex gap-5 text-2xl">
      <a href="https://es-la.facebook.com/"> <FaFacebookSquare /> </a>
      <a> <FaInstagram /> </a>
      <a> <FaTwitterSquare/> </a>
      </div>
    </div>
    </footer>
  );
};

export default Footer;