// src/components/Login.jsx
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/auth/login', {
                email,
                password,
            });

            const token = response.data.token;

            // Guardar el token en localStorage
            localStorage.setItem('token', token);

            alert('Inicio de sesión exitoso ✅');

            // Redirigir después del login, por ejemplo a /rutinas
            navigate('/rutinas');
        } catch (error) {
            console.error('Error al iniciar sesión:', error);
            alert('Credenciales incorrectas');
        }
    };

    return (
        <div className="max-w-md mx-auto mt-10 p-6 border rounded shadow">
            <h2 className="text-xl font-bold mb-4">Iniciar Sesión</h2>
            <form onSubmit={handleLogin}>
                <div className="mb-3">
                    <label className="block">Correo electrónico:</label>
                    <input
                        type="email"
                        className="border px-3 py-2 w-full rounded"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label className="block">Contraseña:</label>
                    <input
                        type="password"
                        className="border px-3 py-2 w-full rounded"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button
                    type="submit"
                    className="bg-blue-600 text-white py-2 px-4 rounded hover:bg-blue-700"
                >
                    Iniciar sesión
                </button>
            </form>
        </div>
    );
};

export default Login;
