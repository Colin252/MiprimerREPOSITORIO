import React, { useState } from "react";

const CrearRutina = () => {
    const [nombreRutina, setNombreRutina] = useState("");
    const [mensaje, setMensaje] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        const token = localStorage.getItem("token");

        if (!token) {
            setMensaje("❌ Token no disponible. Por favor inicia sesión.");
            return;
        }

        try {
            const response = await fetch("http://localhost:8080/api/routines", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    Authorization: `Bearer ${token}`,
                },
                body: JSON.stringify({
                    name: nombreRutina,
                    description: "Creada desde el frontend",
                }),
            });

            if (response.ok) {
                setMensaje("✅ Rutina creada exitosamente");
                setNombreRutina("");
            } else {
                const errorData = await response.text();
                console.error("Respuesta del servidor:", errorData);
                setMensaje("❌ Error al crear la rutina");
            }
        } catch (error) {
            console.error("Error en la solicitud:", error);
            setMensaje("❌ Error de red al conectar con el backend");
        }
    };

    return (
        <div style={{ padding: "20px" }}>
            <h2>FitFlow App</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Nombre de rutina"
                    value={nombreRutina}
                    onChange={(e) => setNombreRutina(e.target.value)}
                    required
                    style={{ padding: "10px", width: "300px" }}
                />
                <br />
                <button
                    type="submit"
                    style={{
                        marginTop: "10px",
                        padding: "10px",
                        background: "#2563eb",
                        color: "white",
                        border: "none",
                    }}
                >
                    Crear rutina
                </button>
            </form>
            {mensaje && (
                <p
                    style={{
                        marginTop: "15px",
                        color: mensaje.startsWith("✅") ? "green" : "red",
                    }}
                >
                    {mensaje}
                </p>
            )}
            <p style={{ marginTop: "10px" }}>Guardar Rutina</p>
        </div>
    );
};

export default CrearRutina;
