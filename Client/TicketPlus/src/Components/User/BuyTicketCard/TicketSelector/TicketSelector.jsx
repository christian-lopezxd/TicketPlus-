import React from "react";
import { useState } from "react";


import TicketSelectorController from "./TicketSelectorController/TicketSelectorController";



const TicketSelector = () => {
  

  const data =  [
    { nombre: 'Bronze', precio: 10,sum:1,  },
    { nombre: 'Silver', precio: 20,sum:0,  },
    { nombre: 'Gold', precio: 30, sum:0, },
    { nombre: 'Platinum', precio: 40,sum:0, },
    { nombre: 'Diamond', precio: 50,sum:0, }
  ];

  

  const suma = data.reduce((total, objeto) => total + objeto.precio, 0);




  
 

  return (
    <div className="w-1/2 xl:w-full text-center bg-selector p-5  font-montserrat  text-2xl  flex flex-col gap-5 rounded-lg">
      <div className="flex justify-between font-bold">
        <h1 className="pl-5"> Tier</h1>
        <h1> Amount</h1>
        <h1 className="pr-5"> Price</h1>
      </div>

      
      <ul className="flex flex-col gap-5">
        {data.map((data, index) => (
          <li key={index}>
           <div className="flex justify-center ">
        <div className="flex justify-start w-1/2 2xl:p-0 pl-5">
          <h1>{data.nombre}</h1>
        </div>
        <TicketSelectorController   />
        
        
        <div className="flex justify-end w-1/2 pr-5">
          <h1> ${data.precio}</h1>
        </div>
      </div>
          </li>
        ))}
      </ul>
      <h1 className="text-right">Total: {suma} </h1>
    </div>
  );
};

export default TicketSelector;
