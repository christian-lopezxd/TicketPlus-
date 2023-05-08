import React from "react";
import Anchors from "./Anchors/Anchors";



const Navbar = () => {
  return (
    <div className="bg-grissoft h-20 flex justify-between p-2 items-center sticky top-0">
      <p className="text-white font-Lilita text-5xl">Ticketplus</p>
      <Anchors />
    </div>
  );
};

export default Navbar;
