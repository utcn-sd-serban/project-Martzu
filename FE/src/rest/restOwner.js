const BASE_URL = "http://localhost:8080";

export default class RestOwner
{
    setUser(username, password)
    {
        this.username = username;
        this.password = password;
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    login()
    {
        return fetch(BASE_URL + "/login-owner", {
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
        return fetch(BASE_URL + "/create-owner", {
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

