import { useEffect, useState } from "react";
import axios from "axios";

const RoutineList = () => {
    const [routines, setRoutines] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/api/routines")
            .then((res) => setRoutines(res.data))
            .catch((err) => console.error("Error cargando rutinas:", err));
    }, []);

    return (
        <div className="p-6">
            <h2 className="text-2xl font-bold mb-4">Rutinas disponibles</h2>
            <ul className="space-y-4">
                {routines.length > 0 ? routines.map((routine) => (
                    <li key={routine.id} className="bg-white rounded-xl p-4 shadow-md">
                        <h3 className="text-lg font-semibold">{routine.name}</h3>
                        <p className="text-gray-600">{routine.description}</p>
                    </li>
                )) : (
                    <p className="text-gray-500">No hay rutinas registradas aún.</p>
                )}
            </ul>
        </div>
    );
};

export default RoutineList;
