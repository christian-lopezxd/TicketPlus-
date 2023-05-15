import React from "react";
import LoginCard from "../../Components/NoAuth/LoginCard/LoginCard";
import NoAuthNavBar from "../../Components/NoAuth/NoAuthNavbar/NoAuthNavbar";
import Footer from "../../Components/User/Footer/Footer";



const Login = () => {
  return (
    <section className="bg-backgroundicons bg-repeat">
      <NoAuthNavBar/>
      <div className="h-[92vh] flex items-center justify-center">
        <LoginCard />
      </div>

      <Footer />
    </section>
  );
};

export default Login;
