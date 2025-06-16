import React from 'react';
import Boton from './components_Son/Boton';
import RutinaForm from './components_Son/RutinaForm';

function App() {
    return (
        <div>
            <h1>FitFlow App</h1>
            <RutinaForm />
            <Boton texto="Guardar Rutina" />
        </div>
    );
}

export default App;
