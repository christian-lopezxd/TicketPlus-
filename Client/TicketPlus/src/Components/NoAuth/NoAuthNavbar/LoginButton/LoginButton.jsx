import React from "react";
import { NavLink } from "react-router-dom";

const LoginButton = () => {
  return (
    <div>
      <NavLink to="/Register">
        <button className="bg-newblue hover:bg-darkblue py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 ">
          {" "}
          Sign Up{" "}
        </button>
      </NavLink>

      <NavLink to="/login">
        {" "}
        <button className="bg-newblue hover:bg-darkblue py-4 px-4 rounded font-montserrat text-white font-normal py-1 px-3 ">
          {" "}
          Sign in{" "}
        </button>
      </NavLink>
    </div>
  );
};

export default LoginButton;
