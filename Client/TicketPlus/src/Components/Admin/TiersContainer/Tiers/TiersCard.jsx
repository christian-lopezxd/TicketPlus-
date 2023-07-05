import React from "react";

const TiersCard = (props) => {
    return(
        <div className="bg-grissoft text-white w-[50%] rounded px-4 py-3 justify-center font-bold text-xl items-center">
            <h1>{`Tier name:    ${props.tier}`}</h1>

            <h1>{`Tier price:    $${props.price}`}</h1>
            <h1>{`Tier people capacity: ${props.capacity}`}</h1>


        </div>
    )
}

export default TiersCard;