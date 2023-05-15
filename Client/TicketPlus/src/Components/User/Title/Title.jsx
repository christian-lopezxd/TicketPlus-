import React from "react";


const Title = (props) => {
    return (
        <div className="bg-darkwhite opacity-90 p-2">
            <h1 className="text-center font-lilita text-6xl text-white ">{props.title}</h1>

        </div>
    )
}

export default Title;   