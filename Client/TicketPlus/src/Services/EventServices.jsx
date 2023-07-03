import React from "react";
import axios from "axios";
const url = "http://162.243.162.41"

const EventServices = () => {}


EventServices.getAllActive = async (page) => {



        try{
          const response = await axios.get(`${url}/event/get-all?page=${page}`,   {
            
            headers: {
              'Authorization': 'Bearer ' + localStorage.getItem("token")
            }
            
            }) 
            
            
          return response.data
      }catch(error){
          throw error
      }
}

EventServices.getOne = async (params) => {
    try{
        const response = await axios.get(`${url}/guest/event/get-one/${params}`,   {
          
          headers: {
            'Authorization': 'Bearer ' + localStorage.getItem("token")
          }
          
          }) 
          
          
        return response.data
    }catch(error){
        
    }

}


export default EventServices;