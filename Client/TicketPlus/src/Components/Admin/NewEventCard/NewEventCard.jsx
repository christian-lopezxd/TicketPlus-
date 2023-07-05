import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { ImCheckmark, ImCross } from 'react-icons/im';
import EventServices from "../../../Services/EventServices";
import moment from "moment";

const NewEvent = () => {

  const [categories, SetCategories] = useState([])
  const [places, SetPlaces] = useState()
  

  useEffect( () => {
   
    EventServices.getCategories().then((info) => {
      SetCategories(info);
     
      
    })

    EventServices.getPlaces().then((info) => {
      SetPlaces(info);
     
      
    })
     
     
      
  }, [])


  const [eventCategory, setEventCategory] = useState()
  const [place, setPlace] = useState()
  const [title, setTitle] = useState("")
  const [fakeStartDate, setFakeStartDate] = useState()
  const [fakeEndDate, setFakeEndDate] = useState()
  const [fakeQrScanStartTime, setFakeQrScanStartTime] = useState()
  const [description, setDescription] = useState("")
  const [bannerPicture, SetBannerPicture] = useState([])
  const [cardPicture, SetCardPicture] = useState([])



  const Create = (e) => {
    e.preventDefault();

    if(!title || !description || !place || !eventCategory || !fakeStartDate || !fakeEndDate || !fakeQrScanStartTime){
        alert("se ardió")
        return;
    }
   const startDate = moment(fakeStartDate).format('MMM DD HH:mm:ss YYYY')
  const endDate = moment(fakeEndDate).format('MMM DD HH:mm:ss YYYY')
    const qrScanStartTime =moment(fakeQrScanStartTime).format('MMM DD HH:mm:ss YYYY')
    


    const formData = new FormData();
    formData.append('bannerPicture', bannerPicture);
    formData.append('cardPicture', cardPicture);
    formData.append("eventCategory", eventCategory)
    formData.append("place", place)
    formData.append("title", title)
    formData.append("startDate", startDate)
    formData.append("endDate", endDate)
    formData.append("qrScanStartTime", qrScanStartTime)
    formData.append("description", description)
    
    console.log(formData.get("cardPicture"))
    console.log(formData.get("bannerPicture"))

    EventServices.Create(formData);

}

  return(
    <div>
      <form enctype="multipart/form-data" className="bg-white max-w-4xl mb-8  mx-auto p-6 rounded-b-2xl" onSubmit={(e) => Create(e)}>
        <div className=' grid grid-cols-2 md:grid-cols-1'>
          <div className="justify-items-start p-3" >
            <h2 className="font-bold text-3xl">New Event</h2>
            <label className="font-semibold">Title:</label>
            <input className="bg-selector rounded-md p-2 m-1 w-full" type="text" placeholder="Title" 
            value={title} onChange={(e) => setTitle(e.target.value)}/>
            <label className="font-semibold">Description:</label>
            <input className="bg-selector rounded-md p-2 m-1 w-full" type="text" placeholder="Description"
            value={description} onChange={(e) => setDescription(e.target.value)}/>
            <label className="font-semibold" >Choose a Category:</label>
            <select name="Categorias" className="bg-selector rounded-md p-2 m-1 w-full" 
            value={eventCategory} onChange={(e) => setEventCategory(e.target.value)}>
              <option defaultValue={0}></option>
              {
              categories ? categories.map((category)=>{
                const {idEventCategory, eventCategoryName} = category
                

                return(
                  <option value={idEventCategory}>{`${eventCategoryName}`}</option>
                )
              }) : ""
            }
            </select>

            <label className="font-semibold">Choose a place:</label>
            <select name="Places" className="bg-selector rounded-md p-2 m-1 w-full"
            value={place} onChange={(e) => setPlace(e.target.value)}>
               <option defaultValue={0}></option>
            {
              places ? places.map((place)=>{
                const {idPlace, placeName, addressLocation} = place
                

                return(
                  <option value={idPlace}>{`${placeName}, ${addressLocation}`}</option>
                )
              }) : ""
            }

            </select>
          
            <label className="font-semibold" htmlFor="">Initial Date</label>
            <input 
              className="bg-selector rounded-md p-2 m-1 w-full"
              type="datetime-local" 
              id="initial-date"  
              value={fakeStartDate} onChange={(e) => setFakeStartDate(e.target.value)}
            />
            <label className="font-semibold" htmlFor="">Final Date</label>
            <input 
              className="bg-selector rounded-md p-2 m-1 w-full"
              type="datetime-local" 
              id="final-date" 
              value={fakeEndDate} onChange={(e) => setFakeEndDate(e.target.value)} 
            />
            
            <label className="font-semibold" htmlFor="">QR scan start time</label>
            <input 
              className="bg-selector rounded-md p-2 m-1 w-full"
              type="datetime-local" 
              id="final-date"  
              value={fakeQrScanStartTime} onChange={(e) => setFakeQrScanStartTime(e.target.value)}
            />
            
            
          </div>
          <div className="justify-items-start p-3">
            
            <label className="font-semibold" htmlFor="">Banner</label>
            <input className="bg-selector rounded-md p-2 m-1 w-full" type="file" accept="image/jpeg" 
             onChange={(e) => SetBannerPicture(e.target.files[0])}/>
            <label className="font-semibold" htmlFor="">Card</label>
            <input className="bg-selector rounded-md p-2 m-1 w-full" type="file" accept="image/jpeg" 
             onChange={(e) =>SetCardPicture(e.target.files[0])}/>
          </div>
        </div>
        <div className="w-full">  
          <div className="flex flex-wrap justify-end">
            <button className="flex flex-row items-center gap-2 bg-darkunsuccesful hover:bg-newpink py-2 px-4 mx-2 rounded font-montserrat text-white font-normal" ><ImCross/>Cancel</button>
            <button type="submit" className="flex flex-row items-center gap-2 bg-newblue hover:bg-darkblue py-2 px-4 rounded mx-2 font-montserrat text-white font-normal"><ImCheckmark/>Create</button>
          </div>
        </div>
        </form>
    </div>
  )
}

export default NewEvent;