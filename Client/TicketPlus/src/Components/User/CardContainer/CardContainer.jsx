import React from "react";
import Card from "./Card/Card";



const CardContainer = (props) => {
  
  const Eventos = props.Eventos
  console.log[ Eventos]


  

  return (
    <div className="flex flex-wrap gap-10 justify-center p-5 chibby:px-2 sm:p-10 min-h-80vh" >
     
      {Eventos.map((evento) => {
        const { id, image, title, locate, date, startTime, endTime, category } =
          evento;
        return (
          <Card
            key={id}
            id={id}
            imagen={image}
            titulo={title}
            localizacion={locate}
            fecha={date}
            horaEntrada={startTime}
            horaSalida={endTime}
            categoria={category}
          />
        );
      })}
    </div>
  );
};
export default CardContainer;
