import React from "react";
import { NavLink } from "react-router-dom";
import QRCode from "react-qr-code";
import { ImCross } from "react-icons/im";

const data = "Code"

const QRRedeem = (props) => {
  return (
    <div className="h-[92vh] flex items-center justify-center w-full md:p-3 ">
      <div className="bg-white w-1/2 mb-2 chibby:w-full sm:w-[50%]  p-6 rounded-2xl">
        <div></div>
        <div className="flex flex-col p-2 items-center">
          <h2 className="text-grissoft font-semibold text-2xl text-center p-3 mb-5">
            {props.title}{" "}
          </h2>
          <div className="bg-softblack h-[50%] w-[50%] rounded-xl mb-5">
            <QRCode
              size={256}
              style={{ height: "auto", maxWidth: "100%", width: "100%" }}
              value={data}
              viewBox={`0 0 256 256`}
            />
          </div>
        </div>
        <div className="flex flex-wrap justify-end">
          <NavLink to={`/MyTickets`}>
            <button className=" flex flex-row items-center gap-2 bg-unsuccesful hover:bg-darkunsuccesful rounded font-montserrat text-white font-normal py-2 px-4 ">
              <ImCross />
              Cancel
            </button>
          </NavLink>
        </div>
      </div>
    </div>
  );
};

export default QRRedeem;
