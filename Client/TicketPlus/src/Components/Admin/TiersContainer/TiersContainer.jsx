import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useParams } from "react-router";
import EventServices from "../../../Services/EventServices";
import TiersCard from "./Tiers/TiersCard";

const TiersContainer = () => {
    const params = useParams().id;

    const [page, setPage] = useState(0);
  const [data, setData] = useState([])

  
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
    EventServices.getTiersByEvent( params, page,).then((info) => {
      setData(info);
      
    });

   
    
  }, [page]);
  


    return(
        <div className="flex flex-col w-full justify-center items-center mt-10 gap-3">

{ 
      data ? data.map((tiers) => {
       

        const {idTier, tier, price, capacity } = tiers;
        return(
           <TiersCard
           key= {idTier}
           code={idTier}
            tier={tier} 
            price={price} 
            capacity={capacity} 
           />
           );

      }) : []
      }
            

            <div className="flex gap-2 justify-center p-5">
        <button className="bg-[#374259]  hover:bg-[#545B77] font-semibold w-fit p-5 text-white h-[3rem] flex items-center" onClick={handleDecrement}>prev</button>
        <button className="bg-[#374259]  hover:bg-[#545B77] font-semibold w-fit p-5 text-white h-[3rem] flex items-center" onClick={handleIncrement}>next</button>
      </div>

        </div>

    )

}

export default TiersContainer;