import React from "react";
import LoginCard from "../Components/NoAuth/LoginCard/LoginCard";
import Footer from "../Components/User/Footer/Footer";
import Navbar from "../Components/User/Navbar/Navbar";

const Login = () => {
    return(
        <section className="bg-backgroundicons bg-repeat">
        <Navbar />
        <div className="h-[92vh] flex items-center justify-center">
        <LoginCard />
        
        </div>
        
        <Footer />

        </section>
    )
}

export default Login;