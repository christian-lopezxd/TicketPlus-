import React from 'react';


const Banner = (props) => {
    return(
        <div className='w-100 h-[40vh]'>
            <img className="h-full w-full" src={`http://162.243.162.41/guest/event/picture/${props.image}`} />

        </div>
    )
}

export default Banner;