import React from "react";
import { IoMailOutline } from "react-icons/io5";
import { RxLockClosed } from "react-icons/rx";
import { FcGoogle } from "react-icons/fc";
import FormController from "./FormController/FormController";
import { useState } from "react";
import { useEffect } from "react";
import AuthServices from "../../../Services/AuthServices";
import { useNavigate } from "react-router";

const LoginCard = () => {

  const navigate = useNavigate()
  

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
    


  const Create = (e) => {
      e.preventDefault();

      if(!email || !password){
          alert("Ingresa credenciales valias")
          return;
      }

    
      
      AuthServices.login(email, password, navigate)
      
    }

  return (
    <form onSubmit={(e) => Create(e)} className="flex flex-col bg-white px-10 py-10 rounded-3xl  w-1/3 md:w-screen sm:w-3/4 sm:m-2 xl:w-1/2 ">
      <h1 className="font-lilita font-bold text-grissoft text-center text-5xl pb-4 ">
        TicketPlus
      </h1>

      <div className=" flex flex-col mt-8 gap-y-2">
        <div className="">
          <div className="text-lg xl:text-base text-grissoft">Email</div>
          <label className="relative block text-grissoft ">
            <span className="absolute inset-y-0 flex text-grissoft items-center">
              <IoMailOutline className="h-4 w-4 fill-background font-semibold" />
            </span>
            <input
              name="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="w-full text-sm p-2 pl-5 pr-3 bg-transparent border-b border-gray-500 focus:outline-none"
              type="email"
              placeholder="Enter your email adress"
              required
            />
          </label>
        </div>

        <div className="">
          <label className="text-lg xl:text-base text-grissoft">
            Password
          </label>
          <label className="relative block  text-grissoft">
            <span className="absolute inset-y-0 flex items-center text-grissoft">
              <RxLockClosed className="h-4 w-4 fill-background " />
            </span>
            <input
              name="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="w-full text-sm p-2 pl-5 bg-transparent border-b border-gray-500 focus:outline-none"
              type="password"
              placeholder="Enter your password"
              required
            />
          </label>
        </div>

        <div>
            <div className="flex flex-row justify-between text-xs mt-8">
                <div className="inline-flex gap-x-1">
                    <input className="w-3 y-3" type="checkbox" />
                    <label>Remember me</label>
                </div>
            </div>

            <div className="flex justify-center text-white mt-10">
               <button type="submit" className="font-monserrat font-semibold text-white bg-grissoft py-2 px-4 rounded-2xl w-full text-center">Login</button>
            </div>
            
        </div>
        

        <h1 className="text-center font-montserrat font-semibold m-2">First time? Sing up with google</h1>
        <div className="flex justify-center text-6xl" >
          <FcGoogle/>
        </div>
      </div>
      
    </form>
  );
};


export default LoginCard;
