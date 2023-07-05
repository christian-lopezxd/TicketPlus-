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


EventServices.getCategories = async() => {

  try{
    const response = await axios.get(`${url}/category/get-all`,   {


      
      headers: {
        'Authorization': 'Bearer ' + localStorage.getItem("token")
      }
      
      }) 
      
      
    return response.data

}catch(error){
    
}

}


EventServices.getPlaces = async() => {
  

  try{
    const response = await axios.get(`${url}/place/get-all`,   {
      
      headers: {
        'Authorization': 'Bearer ' + localStorage.getItem("token")
      }
      
      }) 
      
    return response.data

}catch(error){
    
}
  

}

EventServices.Create = async(formData) => {
  
 

  
  try{
    const response = await axios.postForm(`${url}/event/create`, formData,   {

      headers: {
        "Content-Type": "multipart/form-data",
        "Authorization":'Bearer ' + localStorage.getItem("token")
      }
     
      }) 
      
      alert("evento creado")
      console.log(response.data)
    return response.data

}catch(error){
    
}

}


EventServices.addTier = async (params, tier, price, capacity) => {

  const config = {
    headers: {
        
        "Authorization":'Bearer ' + localStorage.getItem("token")
    }
}


  try{
    const response = await axios.post(`${url}/event/add-tier/${params}`, {
      tier,
      price,
      capacity

    }, config 

      ) 
      
      alert("tier added successfully")
      window.location.reload()
      
      console.log(response.data)
    return response.data

}catch(error){
    
}




}

EventServices.getTiersByEvent = async (params, page) => {

  try{
    const response = await axios.get(`${url}/event/get-tiers/${params}?page=${page}`, {
      headers: {
        'Authorization': 'Bearer ' + localStorage.getItem("token")
      }

    }

      ) 
      
    
      
    return response.data.content.tiers

}catch(error){
    
}

}

export default EventServices;