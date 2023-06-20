import React from "react";
import { Carousel } from 'react-responsive-carousel';
import 'react-responsive-carousel/lib/styles/carousel.min.css';

const Carrousel = () => {
    return (
        <Carousel axis="horizontal" autoPlay="false" showThumbs={false} infiniteLoop={true}>
          <div>
            <img src="https://i.pinimg.com/originals/4b/fc/8c/4bfc8cf9fdda46cbb9890d55fde35218.jpg" alt="Imagen 1" />

          </div>
          <div>
            <img src="https://i.pinimg.com/originals/4b/fc/8c/4bfc8cf9fdda46cbb9890d55fde35218.jpg" alt="Imagen 2" />
            
          </div>
          <div>
            <img src="https://i.pinimg.com/originals/4b/fc/8c/4bfc8cf9fdda46cbb9890d55fde35218.jpg" alt="Imagen 3" />
           
          </div>
        </Carousel>
      );
}

export default Carrousel;