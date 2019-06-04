const BASE_URL = "http://localhost:8080";

export default class RestOwnedStocks
{
    setUser(username, password)
    {
        this.username = username;
        this.password = password;
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    getOwnedStocks()
    {
        debugger;
        const address = BASE_URL + "/owned-stocks/"  + this.username;
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
}

