import React from "react";
import { useState } from "react";
import EventServices from "../../../Services/EventServices";
import Card from "./Card/Card";
import { useEffect } from "react";
import moment from "moment";




const CardContainer = () => {
  const [page, setPage] = useState(0);
  const [data, setData] = useState(null)

  
  const handleDecrement = () => {
    if (page > 0) {
      setPage((prevCount) => prevCount - 1);
    
    }
    
    
  };


  const handleIncrement = () => {
    if (page < data.totalPages - 1) {
      setPage((prevCount) => prevCount + 1);
    }
  };   



  useEffect(() => {
    EventServices.getAllActive(page).then((info) => {
      setData(info);
      
    });

   
    
  }, [page]);
  


  

  return (
    <div>
      <div className="flex flex-wrap min-h-[84vh] gap-10 justify-center p-5 chibby:px-2 sm:p-10 min-h-80vh " >
     
     {
     data ? data.content.map((evento, ) => {
       const { idEvent, cardPicture, description, eventCategory, endDate, startDate ,title,  place} =
         evento;

         
       const { idEventCategory, eventCategoryName }
        = eventCategory;
        const {addressLocation, idPlace, placeName} = 
        place
       return (
         <Card
           key={idEvent}
           idEvent={idEvent}
           description={description}
           imagen={cardPicture}
           titulo={title}
           localizacion={placeName}
           ciudad = {addressLocation}
           fecha={moment(startDate).format('DD/MM/YYYY')}
           horaEntrada={moment(startDate).format('HH:mm')}
           horaSalida={moment(endDate).format('HH:mm')}
           categoria={eventCategoryName}
         />
       );
     }) : ""
   }


   </div>
   <div className="flex gap-2 justify-center p-5">
        <button className="bg-[#374259]  hover:bg-[#545B77] font-semibold w-fit p-5 text-white h-[3rem] flex items-center" onClick={handleDecrement}>prev</button>
        <button className="bg-[#374259]  hover:bg-[#545B77] font-semibold w-fit p-5 text-white h-[3rem] flex items-center" onClick={handleIncrement}>next</button>
      </div>
    </div>
  );
};
export default CardContainer;
