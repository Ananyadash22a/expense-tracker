function addIncome() {
    const data = {
        amount: amount.value,
        source: source.value,
        userId: localStorage.getItem("userId")
    };

    fetch(BASE_URL + "/income", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(() => location.href = "dashboard.html");
}