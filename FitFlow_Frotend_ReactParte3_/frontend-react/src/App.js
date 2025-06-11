import React from 'react';
import Boton from './components/Boton';
import RutinaForm from './components/RutinaForm';

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
