import React, { useEffect, useState } from 'react';
import api from '../services/api';

const MostrarRutinas = () => {
    const [rutinas, setRutinas] = useState([]);

    useEffect(() => {
        const fetchRutinas = async () => {
            try {
                const response = await api.get('/routines');
                setRutinas(response.data);
            } catch (error) {
                console.error('Error al obtener rutinas:', error);
            }
        };

        fetchRutinas();
    }, []);

    return (
        <div className="p-4">
            <h2 className="text-2xl font-bold mb-4">Rutinas Registradas</h2>
            <ul className="space-y-2">
                {rutinas.map((rutina) => (
                    <li key={rutina.id} className="bg-white p-4 rounded shadow">
                        <h3 className="text-lg font-semibold">{rutina.name}</h3>
                        <p>{rutina.description}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default MostrarRutinas;
