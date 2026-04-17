const userId = localStorage.getItem("userId");

if (!userId) location.href = "login.html";

fetch(BASE_URL + "/dashboard/" + userId)
.then(res => res.json())
.then(d => {
    income.innerText = d.income;
    expense.innerText = d.expense;
    balance.innerText = d.balance;
    score.innerText = d.healthScore;
    suggestion.innerText = d.suggestion;
});

function goExpense() {
    location.href = "expense.html";
}

function goIncome() {
    location.href = "income.html";
}

function logout() {
    localStorage.clear();
    location.href = "login.html";
}