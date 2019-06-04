const BASE_URL = "http://localhost:8080";

export default class RestInvestor
{
    setUser(username, password)
    {
        this.username = username;
        this.password = password;
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    login()
    {
        debugger;
        return fetch(BASE_URL + "/login-investor", {
            method: "POST",
            body: JSON.stringify({
                username: this.username,
                password: this.password
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => {
            return response;
        });
    }

    create(username, password)
    {
        debugger;
        return fetch(BASE_URL + "/create-investor", {
            method: "POST",
            body: JSON.stringify({
                username: username,
                password: password
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => {
            return response.json()});
    }
}

