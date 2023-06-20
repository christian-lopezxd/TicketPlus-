import { Bar } from 'react-chartjs-2';
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    PointElement,
    BarElement,
    Title,
    Tooltip,
    Legend,
    Filler,
} from 'chart.js';

ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    BarElement,
    Title,
    Tooltip,
    Legend,
    Filler
);

var Venta_de_Entradas = [72, 156, 205, 136];
var Tipos_de_Entradas = ["General", "Premium", "Platinum", "VIP"];

var misoptions = {
    responsive : true,
    animation : false,
    plugins : {
        legend : {
            
        }
    },
    scales : {
        y : {
            min : 0,
            max : 300
        },
        x: {
            ticks: { color: 'rgba(0, 220, 195)'}
        }
    }
};

var midata = {
    labels: Tipos_de_Entradas,
    datasets: [
        {
            label: 'Venta de Entradas',
            data: Venta_de_Entradas,
            backgroundColor: 'rgba(0, 220, 195, 0.5)'
        }
    ]
};

export default function Bars() {
    return <Bar data={midata} options={misoptions} />
}