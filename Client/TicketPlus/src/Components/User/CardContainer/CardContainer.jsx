import React from "react";
import Card from "./Card/Card";
const eventos = [
    {
      id: 1,
      imagen: "https://psicocode.com/wp-content/uploads/2023/02/calamardo.jpg",
      titulo: "titulo 1",
      localizacion: "Lugar 1",
      fecha: "2023-06-15",
      horaEntrada: "18:00",
      horaSalida: "23:00",
      categoria: "concierto"
    },
    {
      id: 2,
      imagen: "https://pbs.twimg.com/media/EdAiTGDXsAwi2XP.jpg",
      titulo: "titulo 2",
      localizacion: "Lugar 2",
      fecha: "2023-06-16",
      horaEntrada: "19:30",
      horaSalida: "22:30",
      categoria: "concierto"
    },
    {
      id: 3,
      imagen: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9zFajZrBbr-MS__vcvNVVgkv9EpPAIEahYw&usqp=CAU",
      titulo: "titulo 2",
      localizacion: "Lugar 3",
      fecha: "2023-06-17",
      horaEntrada: "20:00",
      horaSalida: "00:00",
      categoria: "entretenimiento"
    },
   
    {
      id: 4,
      imagen: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcyMuXWcdBhH_zNxP-yRmEJsGLQKuOOeO89w&usqp=CAU",
      titulo: "titulo 2",
      localizacion: "Lugar 5",
      fecha: "2023-06-18",
      horaEntrada: "17:00",
      horaSalida: "21:00",
      categoria: "concierto"
    },
    {
      id: 5,
      imagen: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTG1U_F78hEcSN2pM02BKTmXijikBvLT5fbDA&usqp=CAU",
      titulo: "titulo 5",
      localizacion: "Lugar 5",
      fecha: "2023-06-19",
      horaEntrada: "19:00",
      horaSalida: "23:30",
      categoria: "social"
    },
    {
        id: 6,
        imagen: "https://assetsio.reedpopcdn.com/new-pokemon-anime.jpeg?width=1600&height=900&fit=crop&quality=100&format=png&enable=upscale&auto=webp",
        titulo: "titulo",
        localizacion: "Lugar 5",
        fecha: "2023-06-19",
        horaEntrada: "19:00",
        horaSalida: "23:30",
        categoria: "social"
      },
      {
        id: 7,
        imagen: "https://m.media-amazon.com/images/M/MV5BZWEzMWFmMDctMDNmNi00NzVjLTgyNmQtNGY5Nzc1N2E4MGM0XkEyXkFqcGdeQXVyNzI3NjY3NjQ@._V1_.jpg",
        titulo: "titulo",
        localizacion: "Lugar 5",
        fecha: "2023-06-19",
        horaEntrada: "19:00",
        horaSalida: "23:30",
        categoria: "social"
      },
      {
        id: 8,
        imagen: "https://cdn.pixabay.com/photo/2020/08/10/13/51/pikachu-5477886_640.jpg",
        titulo: "titulo",
        localizacion: "Lugar 5",
        fecha: "2023-06-19",
        horaEntrada: "19:00",
        horaSalida: "23:30",
        categoria: "social"
      },
      {
        id: 9,
        imagen: "https://storage.googleapis.com/proudcity/mebanenc/uploads/2021/03/placeholder-image.png",
        titulo: "titulo",
        localizacion: "Lugar 5",
        fecha: "2023-06-19",
        horaEntrada: "19:00",
        horaSalida: "23:30",
        categoria: "social"
      },
      {
        id: 10,
        imagen: "https://storage.googleapis.com/proudcity/mebanenc/uploads/2021/03/placeholder-image.png",
        titulo: "titulo",
        localizacion: "Lugar 5",
        fecha: "2023-06-19",
        horaEntrada: "19:00",
        horaSalida: "23:30",
        categoria: "social"
      },
      {
        id: 11,
        imagen: "https://storage.googleapis.com/proudcity/mebanenc/uploads/2021/03/placeholder-image.png",
        titulo: "titulo",
        localizacion: "Lugar 5",
        fecha: "2023-06-19",
        horaEntrada: "19:00",
        horaSalida: "23:30",
        categoria: "social"
      },
      {
        id: 5,
        imagen: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTG1U_F78hEcSN2pM02BKTmXijikBvLT5fbDA&usqp=CAU",
        titulo: "titulo",
        localizacion: "Lugar 5",
        fecha: "2023-06-19",
        horaEntrada: "19:00",
        horaSalida: "23:30",
        categoria: "social"
      },
      {
        id: 5,
        imagen: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTG1U_F78hEcSN2pM02BKTmXijikBvLT5fbDA&usqp=CAU",
        titulo: "titulo",
        localizacion: "Lugar 5",
        fecha: "2023-06-19",
        horaEntrada: "19:00",
        horaSalida: "23:30",
        categoria: "social"
      },
      {
        id: 5,
        imagen: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTG1U_F78hEcSN2pM02BKTmXijikBvLT5fbDA&usqp=CAU",
        titulo: "titulo",
        localizacion: "Lugar 5",
        fecha: "2023-06-19",
        horaEntrada: "19:00",
        horaSalida: "23:30",
        categoria: "social"
      },
    
  ];
  
  console.log(eventos);
  

const CardContainer =()=>{
    return (
        <div className="flex flex-wrap gap-10 justify-center p-5 chibby:px-2 sm:p-10 min-h-80vh">
           {
            eventos.map((evento)=> {
                const {id, imagen, titulo, localizacion, fecha, horaEntrada, horaSalida, categoria} = evento
                return(
                    <Card  id={id} imagen={imagen} titulo={titulo} localizacion={localizacion} fecha={fecha} horaEntrada={horaEntrada} horaSalida={horaSalida} categoria={categoria} />
                )
            }
            )

           } 
           
            
        </div>
    )
}
export default CardContainer;