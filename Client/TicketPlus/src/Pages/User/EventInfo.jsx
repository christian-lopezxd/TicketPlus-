import React from "react";
import Banner from "../../Components/User/Banner/Banner";
import EventInfoCard from "../../Components/User/EventInfoCard/EventInfoCard";
import Footer from "../../Components/User/Footer/Footer";
import Navbar from "../../Components/User/Navbar/Navbar";
import Title from "../../Components/User/Title/Title";
import { useParams } from "react-router-dom";
import { useState } from "react";
import EventServices from "../../Services/EventServices";
import { useEffect } from "react";
import moment from "moment";



const EventInfo = () => {
  const params = useParams();
  

  const[category, setCategory] = useState("")
  const [place, setPlace] = useState("")
  const [city, setCity] = useState("")
  
  
  const [event, setEvent] = useState({});
  
  useEffect(() => {
    EventServices.getOne(params.idEvent).then((info) => {
      setEvent(info);
      setCategory(info.eventCategory.eventCategoryName)
      setPlace(info.place.placeName)
      setCity(info.place.addressLocation)
    });

   
    
  }, [params]);

  
  

  return (
    <section className="bg-backgroundicons bg-repeat">

      <Navbar />
      <Banner image={event.bannerPicture}/>
      <Title title= {event.title} />
      <EventInfoCard 
      description={event.description}
      id={event.idEvent}
      Category={category}
      Date={`${moment(event.startDate).format('DD/MM/YYYY')} - ${moment(event.endDate).format('DD/MM/YYYY')}`}
      Hour={`${moment(event.startDate).format('HH:mm')} - ${moment(event.endDate).format('HH:mm')} `}
     
      Location={ `${place}, ${city} `}
      
       />
      <Footer />
      
    </section>
  );
};

export default EventInfo;
