import React from "react";




const FormController = () => {
    return (
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
    )
}

export default FormController;