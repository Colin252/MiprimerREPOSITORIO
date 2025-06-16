import React, { useState } from 'react';

function RutinaForm() {
    const [nombre, setNombre] = useState('');
    const [mensaje, setMensaje] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (nombre.trim() === '') {
            setMensaje('❌ El nombre de la rutina no puede estar vacío.');
            return;
        }

        try {
            const response = await fetch('http://localhost:8080/api/routines/public', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ name: nombre }), // 👈 El backend espera "name"
            });

            if (!response.ok) {
                throw new Error('Error al crear la rutina');
            }

            const data = await response.json();
            setMensaje(`✅ Rutina creada con ID: ${data.id}`);
            setNombre('');
        } catch (error) {
            setMensaje('❌ Error: ' + error.message);
        }
    };

    return (
        <form onSubmit={handleSubmit} className="flex flex-col gap-2 max-w-sm">
            <input
                type="text"
                value={nombre}
                onChange={(e) => setNombre(e.target.value)}
                placeholder="Nombre de rutina"
                className="border p-2 rounded"
            />
            <button type="submit" className="bg-blue-600 text-white p-2 rounded hover:bg-blue-700">
                Crear rutina
            </button>

            {mensaje && (
                <p
                    className={
                        mensaje.startsWith('✅')
                            ? 'mt-2 text-green-600'
                            : 'mt-2 text-red-600'
                    }
                >
                    {mensaje}
                </p>
            )}
        </form>
    );
}

export default RutinaForm;
