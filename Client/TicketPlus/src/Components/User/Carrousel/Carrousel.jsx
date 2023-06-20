import React from "react";
import { Carousel } from "react-responsive-carousel";
import "react-responsive-carousel/lib/styles/carousel.min.css";

const banners = [
  {
    image:
      "https://i.pinimg.com/originals/71/7d/c3/717dc3b6679dae09102584553c71c60d.jpg",
      id: "1"
    },
  {
    image:
      "https://i.pinimg.com/originals/4b/fc/8c/4bfc8cf9fdda46cbb9890d55fde35218.jpg",
      id: "1"
    },{
    image : "https://creative-commission.com/sites/default/files/styles/img_res_4/public/media/img/2022/03/img_45394_729983_07f04e80.jpeg?itok=IK2Kz0NM",
    id: "1"},
];

const Carrousel = () => {
  return (
    <Carousel axis="horizontal" autoPlay="false" showThumbs={false} infiniteLoop={true} className="chibby:hidden" >
        {
           banners.map( (banner) => {
            const {image, id} = banner
            return(
                <div className="">
                <img src={ image } className="object-fill h-[400px] md:h-[200px]  w-full" alt={id} />
              </div>
            )
           })
               
        }
        
     </Carousel>
  );
};

export default Carrousel;
