import React from "react";
import { useParams } from "react-router";
import NoAuthNavBar from "../../Components/NoAuth/NoAuthNavbar/NoAuthNavbar";
import AuthServices from "../../Services/AuthServices";


const Verify = ( ) => {
    const {UUID} = useParams();
    console.log(UUID)

    const verifyAccount = () => {
        AuthServices.Verify(UUID)
    }


    return(
        <section className="bg-backgroundicons bg-repeat">
             <NoAuthNavBar />
             <div className="h-[91.5vh] flex items-center justify-center">
                <div className="bg-white h-[60%] w-[75%] rounded-xl flex flex-col justify-center items-center gap-5">
                    <h1 className="text-6xl font-lilita font-semibold text-center ">
                        Click the button below to verify your account
                    </h1>
                    <button  onClick={verifyAccount} className="bg-newblue hover:bg-darkblue text-white font-semibold py-5 px-10 rounded text-xl">
                        Verify
                    </button>

                </div>
        
      </div>
        </section>
    )
}

export default Verify;