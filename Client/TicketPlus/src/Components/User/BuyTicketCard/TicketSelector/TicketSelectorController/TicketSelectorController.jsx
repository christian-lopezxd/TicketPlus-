import React from "react";
import { useState } from "react";


const  TicketSelectorController = () => {  
    const [quantity, setQuantity] = useState(1);
    const handleDecrement = () => {
        if (quantity > 0) {
          setQuantity((prevCount) => prevCount - 1);
        }
      };
      const handleIncrement = () => {
        if (quantity < 10) {
          setQuantity((prevCount) => prevCount + 1);
        }
      };   
      return(
        <div className="flex flex-row w-full justify-center">
            <button
          type="button"
          className="bg-newblue w-1/10 px-4 text-white font-bold text-3xl rounded-l-lg hover:bg-darkblue"
          onClick={handleDecrement}
        >
          -
        </button>
        <div className="bg-white w-1/2 text-center flex items-center justify-center  ">
          {quantity}
        </div>
        <button
          type="button"
          className="bg-newblue w-1/10 px-4 text-white font-bold text-3xl rounded-r-lg hover:bg-darkblue "
          onClick={handleIncrement}
        >
          +
        </button>
       
        </div>
    )
      
    };
      

      
   

  


export default TicketSelectorController;
