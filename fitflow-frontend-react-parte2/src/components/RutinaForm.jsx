import React, { useState } from 'react';

function RutinaForm() {
    const [nombre, setNombre] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        alert(`Rutina creada: ${nombre}`);
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                value={nombre}
                onChange={(e) => setNombre(e.target.value)}
                placeholder="Nombre de rutina"
            />
            <button type="submit">Crear rutina</button>
        </form>
    );
}

export default RutinaForm;
