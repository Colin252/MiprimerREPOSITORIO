function validateForm() {
    const userName = document.getElementById("userName").value.trim();
    const password = document.getElementById("password").value.trim();

    if (userName === "" || password === "") {
        alert("Por favor, completa todos los campos.");
        return false;
    }

    return true;
}
