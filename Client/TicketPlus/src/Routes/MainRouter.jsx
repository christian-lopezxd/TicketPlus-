import React from "react";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import UserRouter from "./UserRouter";
import AuthRouter from "./AuthRouter";
import EmployeeRouter from "./EmployeeRouter";
import AnalystRouter from "./AnalystRouter";


const MainRouter = () => {
    const role ="User";
    return(
        <BrowserRouter>
        {role === "User" && <UserRouter />}
      {role === "Admin" && <AdminRouter />}
      {role === "Employee" && <EmployeeRouter />}
      {role === "Analyst" && <AnalystRouter />}
      {role === "" && <AuthRouter />}
        </BrowserRouter>
    )
}

export default MainRouter;
