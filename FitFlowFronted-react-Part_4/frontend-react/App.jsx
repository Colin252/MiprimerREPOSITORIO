import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AppLayout from "./Layout_Son/AppLayout"; // Ajusta si la ruta es distinta
import SignInForm from "./Layout_Father/components_Father/auth/SignInForm";
import SignUpForm from "./Layout_Father/components_Father/auth/SignUpForm";
import Dashboard from "./components/Dashboard"; // ✅ Aquí se importa tu dashboard correcto

function App() {
    return (
        <Router>
            <Routes>
                {/* Rutas públicas */}
                <Route path="/" element={<SignInForm />} />
                <Route path="/signin" element={<SignInForm />} />
                <Route path="/signup" element={<SignUpForm />} />

                {/* Rutas dentro del layout */}
                <Route path="/app" element={<AppLayout />}>
                    <Route path="dashboard" element={<Dashboard />} />
                </Route>
            </Routes>
        </Router>
    );
}

export default App;
