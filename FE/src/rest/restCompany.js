const BASE_URL = "http://localhost:8080";

export default class RestCompany
{
    setUser(username, password)
    {
        this.username = username;
        this.password = password;
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    getAllCompanies()
    {
        const address = BASE_URL + "/all-company";
        return fetch(address, {
            method: "GET",
            headers: {
                "Authorization": this.authorization,
            }
        }).then(response => {
            return response.json();
        });

    }

    addCompany(newCompany)
    {
        return fetch(BASE_URL + "/add-company", {
            method: "POST",
            body: JSON.stringify({
                owner: this.username,
                name: newCompany.name,
                tag: newCompany.tag,
                evaluation: newCompany.evaluation,
                sharePrice: newCompany.sharePrice,
                splitFactor: ""
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => {
            return response});
    }

    getCompaniesOfOwner()
    {
        const address = BASE_URL + "/companies/" + this.username;
        return fetch(address, {
            method: "GET",
            headers: {
                "Authorization": this.authorization,
            }
        }).then(response => {
            return response.json();
        });
    }

    split(split, company)
    {
        debugger;
        return fetch(BASE_URL + "/split", {
            method: "POST",
            body: JSON.stringify({
                split: split,
                company: company,
                username: this.username
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type" : "application/json"
            }
        }).then(response => {
            return response});
    }

}

