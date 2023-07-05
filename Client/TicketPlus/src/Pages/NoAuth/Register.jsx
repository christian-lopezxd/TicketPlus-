import React from "react";
import NoAuthNavbar from "../../Components/NoAuth/NoAuthNavbar/NoAuthNavbar";
import RegisterCard from "../../Components/NoAuth/RegisterCard/RegisterCard";


const Register = () => {
  return(
    <section className="m-0 bg-backgroundicons bg-repeat min-h-[100vh]"> 
        <NoAuthNavbar/>
        <div className="flex justify-center items-center h-[91.5vh] ">
        
        <RegisterCard/>
      
    </div>
    </section>
    )
}

export default Register;