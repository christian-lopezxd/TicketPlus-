import React from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import UserRouter from "./UserRouter";
import AuthRouter from "./AuthRouter";
import AdminRouter from "./AdminRouter";
import EmployeeRouter from "./EmployeeRouter";
import AnalystRouter from "./AnalystRouter";
import { useState } from "react";
import { useEffect } from "react";
import AuthServices from "../Services/AuthServices";


const MainRouter = () => {

  const [role, setRole] = useState("")
  let userRole = []
  

  useEffect(() => {
    if(role == "" ){
      userRole = AuthServices.getRole().then((info) => {
      setRole(info)
      })
      
    }
  }, [role]);




   
    return(
        <BrowserRouter>
        {role === "Customer" && <UserRouter />}
      {role === "Event manager" && <AdminRouter />}
      {role === "Employee" && <EmployeeRouter />}
      {role === "Analyst" && <AnalystRouter />}
      {role === "" && <AuthRouter />}
        </BrowserRouter>
    )
}

export default MainRouter;