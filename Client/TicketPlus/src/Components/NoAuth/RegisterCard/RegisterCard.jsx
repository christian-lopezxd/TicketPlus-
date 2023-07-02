import React from "react";
import { IoMailOutline } from "react-icons/io5";
import { RxLockClosed } from "react-icons/rx";
import { AiOutlineUser } from "react-icons/ai";
import AuthServices from "../../../Services/AuthServices";
import { useState } from "react";
import { useNavigate } from "react-router";

const RegisterCard = () => {
  const navigate = useNavigate();

  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [repeatPassword, setRepeatPassword] = useState("");

  const Create = (e) => {
    e.preventDefault();

    if (password == repeatPassword) {
      AuthServices.Register(name, email, password, navigate);
      setName("");
      setEmail("");
      setPassword("");
      setRepeatPassword("");
    } else {
      alert("Contraseñas no coinciden");
    }

    if (!name || !email || !password || !repeatPassword) {
      alert("faltan argumentos");
      return;
    }
  };

  return (
    <form
      onSubmit={(e) => Create(e)}
      className="flex flex-col bg-white px-10 py-10 rounded-3xl text-2xl  w-1/3 md:w-screen sm:w-3/4 sm:m-2 xl:w-1/2 "
    >
      <h1 className="font-bold text-grissoft text-center text-5xl pb-4 ">
        Ticket Plus+
      </h1>

      <div className="text-2xl  flex flex-col mt-8 gap-y-5">
        <div className="">
          <div className=" text-grissoft">Full name</div>
          <label className="relative block text-grissoft ">
            <span className="absolute inset-y-0 flex text-grissoft items-center">
              <AiOutlineUser className="h-4 w-4 fill-background font-semibold" />
            </span>

            <input
              value={name}
              onChange={(e) => setName(e.target.value)}
              className="w-full text-sm p-2 pl-5 pr-3 bg-transparent border-b border-gray-500 focus:outline-none"
              type="name"
              placeholder="Enter your username"
              required
            />
          </label>
        </div>
        <div className="">
          <div className=" text-grissoft">Email</div>
          <label className="relative block text-grissoft ">
            <span className="absolute inset-y-0 flex text-grissoft items-center">
              <IoMailOutline className="h-4 w-4 fill-background font-semibold" />
            </span>

            <input
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              name="email"
              className="w-full text-sm p-2 pl-5 pr-3 bg-transparent border-b border-gray-500 focus:outline-none"
              type="email"
              placeholder="Enter your email adress"
              required
            />
          </label>
        </div>

        <div className="">
          <label className=" text-grissoft">Password</label>
          <label className="relative block  text-grissoft">
            <span className="absolute inset-y-0 flex items-center text-grissoft">
              <RxLockClosed className="h-4 w-4 fill-background " />
            </span>
            <input
              value={password}
              pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*,;.?¿])[a-zA-Z\d!@#$%^&*,;.?¿]{8,}$"
              title="La contraseña debe tener al menos 8 caracteres, incluyendo una minúscula, una mayúscula, un número y un carácter especial."
              onChange={(e) => setPassword(e.target.value)}
              name="password"
              className="w-full text-sm p-2 pl-5 bg-transparent border-b border-gray-500 focus:outline-none"
              type="password"
              placeholder="Enter your password"
              required
            />
          </label>
        </div>

        <div className="">
          <label className="text-grissoft">Repeat Password</label>
          <label className="relative block  text-grissoft">
            <span className="absolute inset-y-0 flex items-center text-grissoft">
              <RxLockClosed className="h-4 w-4 fill-background " />
            </span>
            <input
              value={repeatPassword}
              onChange={(e) => setRepeatPassword(e.target.value)}
              name="password"
              pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*,;.?¿])[a-zA-Z\d!@#$%^&*,;.?¿]{8,}$"
              title="La contraseña debe tener al menos 8 caracteres, incluyendo una minúscula, una mayúscula, un número y un carácter especial."
              className="w-full text-sm p-2 pl-5 bg-transparent border-b border-gray-500 focus:outline-none"
              type="password"
              placeholder="Enter your password again"
              required
            />
          </label>
        </div>
        <button
          type="submit"
          className="font-monserrat font-semibold text-white bg-[#1b2632] hover:bg-black py-2 px-4 rounded-2xl w-full text-center"
        >
          Register
        </button>
      </div>
    </form>
  );
};

export default RegisterCard;