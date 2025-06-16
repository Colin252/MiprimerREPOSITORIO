import React, { useEffect, useState } from "react";
import RoutineForm from "./RutinaForm";
import RoutineList from "./RoutineList";

export default function Dashboard() {
    const [totalRutinas, setTotalRutinas] = useState(0);

    useEffect(() => {
        fetch("http://localhost:8080/api/routines/public")
            .then((res) => res.json())
            .then((data) => setTotalRutinas(data.length))
            .catch((err) => console.error("Error al contar rutinas:", err));
    }, []);

    return (
        <div className="space-y-8 p-4">
            <h1 className="text-3xl font-bold text-gray-800">Dashboard FitFlow 💪</h1>

            {/* Tarjetas de estadísticas */}
            <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
                <div className="p-6 bg-brand-500 text-white rounded-xl shadow-md text-center">
                    <h2 className="text-xl font-semibold">Rutinas totales</h2>
                    <p className="text-3xl mt-2 font-bold">{totalRutinas}</p>
                </div>
                <div className="p-6 bg-gray-100 text-gray-800 rounded-xl shadow-md text-center">
                    <h2 className="text-xl font-semibold">Ejercicios</h2>
                    <p className="text-3xl mt-2 font-bold">35</p>
                </div>
                <div className="p-6 bg-white text-gray-800 rounded-xl shadow-md text-center">
                    <h2 className="text-xl font-semibold">Usuarios</h2>
                    <p className="text-3xl mt-2 font-bold">4</p>
                </div>
            </div>

            {/* Formulario de rutina */}
            <div>
                <h2 className="text-2xl font-semibold mb-4">Crear nueva rutina</h2>
                <RoutineForm />
            </div>

            {/* Lista de rutinas creadas */}
            <RoutineList />
        </div>
    );
}
