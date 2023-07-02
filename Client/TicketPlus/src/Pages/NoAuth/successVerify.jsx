import React from "react";
import { NavLink } from "react-router-dom";
import NoAuthNavBar from "../../Components/NoAuth/NoAuthNavbar/NoAuthNavbar";



const SuccessVerify = ( ) => {
    


    return(
        <section className="bg-backgroundicons bg-repeat">
             <NoAuthNavBar />
             <div className="h-[91.5vh] flex items-center justify-center">
                <div className="bg-white h-[60%] w-[75%] rounded-xl flex flex-col justify-center items-center gap-5">
                    <h1 className="text-6xl font-lilita font-semibold text-center ">
                        Thanks for verify your account!!
                    </h1>
                    <NavLink to="/login">
                    <button className="bg-newblue hover:bg-darkblue text-white font-semibold py-5 px-10 rounded text-xl">
                        Sign In
                    </button>
                    </NavLink>

                </div>
        
      </div>
        </section>
    )
}

export default SuccessVerify;