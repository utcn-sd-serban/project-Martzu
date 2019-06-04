const BASE_URL = "http://localhost:8080";

export default class RestTransaction
{
    setUser(username, password)
    {
        this.username = username;
        this.password = password;
        this.authorization = "Basic " + btoa(username + ":" + password);
    }



    getAllTransactionsOfUser()
    {
        debugger;
        const address = BASE_URL + "/all-transactions/" + this.username;
        return fetch(address, {
            method: "GET",
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => {
            return response.json();
        });
    }

    placeBuyTransactionByName(username, company, stockNumber)
    {
        return fetch(BASE_URL + "/buy-transaction-name", {
            method: "POST",
            body: JSON.stringify({
                userName: username,
                company: company,
                stockNumber: stockNumber
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => {
            return response});
    }

    placeBuyTransactionByTag(username, company, stockNumber)
    {
        debugger;
        return fetch(BASE_URL + "/buy-transaction-tag", {
            method: "POST",
            body: JSON.stringify({
                userName: username,
                company: company,
                stockNumber: stockNumber
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => {
            return response});
    }

    placeSellTransactionByName(username, company, stockNumber)
    {
        return fetch(BASE_URL + "/sell-transaction-name", {
            method: "POST",
            body: JSON.stringify({
                userName: username,
                company: company,
                stockNumber: stockNumber
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => {
            return response});
    }

    placeSellTransactionByTag(username, company, stockNumber)
    {
        return fetch(BASE_URL + "/sell-transaction-tag", {
            method: "POST",
            body: JSON.stringify({
                company: company,
                userName: username,
                stockNumber: stockNumber
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => {
            return response});
    }


}

