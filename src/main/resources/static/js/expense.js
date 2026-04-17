function addExpense() {
    const data = {
        category: category.value,
        amount: amount.value,
        userId: localStorage.getItem("userId")
    };

    fetch(BASE_URL + "/expenses", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
    .then(() => location.href = "dashboard.html");
}