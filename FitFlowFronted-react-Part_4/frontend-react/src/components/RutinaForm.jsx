import { useState } from "react";
import axios from "axios";

const RutinaForm = () => {
    const [nombre, setNombre] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post("http://localhost:8080/api/routines", {
                name: nombre,
                description: "Descripción generada automáticamente",
            });
            alert("Rutina creada con éxito");
            setNombre("");
        } catch (error) {
            console.error("Error al crear rutina:", error);
            alert("Hubo un error al crear la rutina");
        }
    };

    return (
        <form onSubmit={handleSubmit} className="p-4">
            <h2 className="text-xl font-semibold mb-2">Crear nueva rutina</h2>
            <input
                type="text"
                value={nombre}
                onChange={(e) => setNombre(e.target.value)}
                placeholder="Nombre de rutina"
                className="border p-2 w-full rounded mb-4"
            />
            <button
                type="submit"
                className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded w-full"
            >
                Crear rutina
            </button>
        </form>
    );
};

export default RutinaForm;
