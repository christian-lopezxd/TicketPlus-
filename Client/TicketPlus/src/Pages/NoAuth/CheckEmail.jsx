import React from "react";
import NoAuthNavbar from "../../Components/NoAuth/NoAuthNavbar/NoAuthNavbar";


const CheckEmail = () => {
    return(
        <section className="bg-backgroundicons bg-repeat">
            <NoAuthNavbar />
            <div className=" h-[91.5vh] flex items-center justify-center " >
            
            <div className="h-[40%] w-[50%] bg-white flex  items-center justify-center rounded-xl">
                <h1 className="font-lilita text-5xl text-center font-bold"> Please Check your email to activate your account</h1>
            </div>

        </div>
        </section>
    )
}

export default CheckEmail;