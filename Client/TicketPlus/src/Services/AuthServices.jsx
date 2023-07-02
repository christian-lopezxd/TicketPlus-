import React from "react";
import axios from "axios";
const url = "http://localhost:8080"



const AuthServices = () => {}

AuthServices.login = async (email, password , navigate) => {
    
   
    
    
    try{
        const response = await axios.post(`${url}/auth/sign-in/password`, {
            email,
            password,

          }) 

          
          localStorage.setItem("token", response.data.token)
          if(localStorage.getItem("token")){
            navigate("/")
            window.location.reload()
            
          }

        return response.data.token
    }catch(error){
        throw error
    }


}

AuthServices.getUserInfo = async (token) => {
    
  


}

AuthServices.Register = async(rname, email, password) => {
    
  try{
      const response = await axios.post(`${url}/auth/sign-up/password`, {
          name,
          email,
          password,

        }) 

        
        alert(response.data); 
       
      return response.data
      
  }catch(error){
      throw error
  }

}


export default AuthServices