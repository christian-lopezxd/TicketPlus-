import React from "react";
import axios from "axios";
import { useState } from "react";
const url = "http://162.243.162.41"



const AuthServices = () => {}

AuthServices.login = async (email, password, navigate) => {
    
    
    try{
        const response = await axios.post(`${url}/auth/sign-in/password`, {
            email,
            password,

          }) 

          
          localStorage.setItem("token", response.data.token)
          if(localStorage.getItem("token")){
            
            AuthServices.getUUID(response.data.token, navigate)

            
          }

        return response.data.token
    }catch(error){
        throw error
    }


}

AuthServices.loginGoogle = async (idGoogleToken, navigate) => {


 
    
  try{
    const response = await axios.post(`${url}/auth/sign-in/google`, {
      idGoogleToken
  
      }) 
  
      
  
      if(response.status == 200){
      localStorage.setItem("token", response.data.token)
      if(localStorage.getItem("token")){
            
        AuthServices.getUUID(response.data.token, navigate)

        
      }
      }
    return response
}catch(error){
  console.log(error.response.status)
  if(error.response.status == 409){
   
    navigate("/success")
   }
     
}
}

AuthServices.getUUID = async (token, navigate) => {

 


  try{
    const response = await axios.get(`${url}/user/get`,   {
      
      headers: {
        'Authorization': 'Bearer ' + token
      }
      
      }) 

      navigate("/")
      window.location.reload()

      
      localStorage.setItem("UUID", response.data.idUser)
      

    return response.data.idUser
}catch(error){
    throw error
}




    
  


}

AuthServices.Register = async(name, email, password, navigate) => {
    
  try{
      const response = await axios.post(`${url}/auth/sign-up/password`, {
          name,
          email,
          password,

        }) 
        console.log(response)
        
        alert(response.data.message);
        if(response.status== 200){
          navigate("/success")
        } 
        if(response.status == 409){
          alert("Revisa bien los campos")
        } 

       
      return response.data.message
      
  }catch(error){
      throw error
  }

  

}

AuthServices.Verify = async (UUID) => {

  try{
    const response = await axios.patch(`${url}/guest/user/toggle-verify/${UUID}`, {

      }) 
      console.log(response)
      
      alert(response.data.message);
      if(response.status== 200){
        navigate("/")
      } 
      

     
    return response.data
    
}catch(error){
    throw error
}

}


AuthServices.getRole = async () => {

 

  const token = localStorage.getItem("token");
  const UUID = localStorage.getItem("UUID");

  try {
    const response = await axios.get(`${url}/user/get-roles/${UUID}`, {
      headers: {
        'Authorization': 'Bearer ' + token
      }
      

    }) 
    
    
    return (response.data.roles[0].roleName)
    
  } catch (error) {
    throw error
    
  }
}


AuthServices.getUserInfo = async() => {
  const token = localStorage.getItem("token");
  const UUID = localStorage.getItem("UUID");
  try {
    const response = await axios.get(`${url}/user/get-one/${UUID}`, {
      headers: {
        'Authorization': 'Bearer ' + token
      }
      

    }) 
    
    
    return (response.data.roles[0].roleName)
    
  } catch (error) {
    throw error
    
  }
}


export default AuthServices