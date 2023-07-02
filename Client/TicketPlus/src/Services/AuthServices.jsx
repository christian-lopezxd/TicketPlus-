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


export default AuthServices