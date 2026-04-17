function register() {
    const data = {
        name: name.value,
        email: email.value,
        password: password.value
    };

    fetch(BASE_URL + "/auth/register", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(res => res.text())
    .then(() => window.location.href = "login.html");
}

function login() {
    const data = {
        email: email.value,
        password: password.value
    };

    fetch(BASE_URL + "/auth/login", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(res => res.json())
    .then(user => {
        localStorage.setItem("userId", user.id);
        window.location.href = "dashboard.html";
    });
}