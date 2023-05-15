import React from "react";
import { IoMailOutline } from "react-icons/io5";
import { RxLockClosed } from "react-icons/rx";
import { FcGoogle } from "react-icons/fc";
import FormController from "./FormController/FormController";

const LoginCard = () => {
  return (
    <form className="flex flex-col bg-white px-10 py-10 rounded-3xl  w-1/3 md:w-screen sm:w-3/4 sm:m-2 xl:w-1/2 ">
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
              className="w-full text-sm p-2 pl-5 bg-transparent border-b border-gray-500 focus:outline-none"
              type="password"
              placeholder="Enter your password"
              required
            />
          </label>
        </div>

        <FormController />

        <h1 className="text-center font-montserrat font-semibold m-2">First time? Sing up with google</h1>
        <div className="flex justify-center text-6xl" >
          <FcGoogle/>
        </div>
      </div>
    </form>
  );
};

export default LoginCard;
