import React from "react";
import { Carousel } from "react-responsive-carousel";
import "react-responsive-carousel/lib/styles/carousel.min.css";




const Carrousel = (props) => {
  
  const eventos = [...props.Eventos].splice(0, 5)
  return (
    <Carousel axis="horizontal" autoPlay={true} showThumbs={false} infiniteLoop={true}  showStatus={false} className="chibby:hidden" >
        {
          eventos.map( (eventos) => {
            const {id, banner} = eventos
            return(
                <div className="" key={id}>
                <img src={ banner } className="object-fill h-[400px] md:h-[200px]  w-full"  />
              </div>
            )
           })
               
        }
        
     </Carousel>
  );
};

export default Carrousel;
