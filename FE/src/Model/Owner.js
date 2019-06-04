import { EventEmitter} from "events";
import RestOwner from "../rest/restOwner";
import company from "../Model/Company";

class Owner extends EventEmitter
{
    constructor()
    {
        super();
        this.restOwner = new RestOwner();
        this.state = {
            owners : [],
            newOwner:{
                username: "",
                password: ""
            },
            currentOwner:{
                username: "",
                password: ""
            }
        };
    }


    changeCurrentOwnerProperties(property, value)
    {
        this.state = {
            ...this.state,
            currentOwner: {
                ...this.state.currentOwner, [property] : value
            }
        };
        this.emit("change", this.state);
    }

    changeNewOwnerProperties(property, value)
    {
        this.state = {
            ...this.state,
            newOwner : {
                ...this.state.newOwner, [property] : value
            }
        };
        this.emit("change", this.state);
    }



    verifyUser()
    {
        this.restOwner.setUser(this.state.currentOwner.username, this.state.currentOwner.password);
        this.restOwner.login().then(response => {
            if(response.status === 200)
            {
                company.restCompany.setUser(this.state.currentOwner.username, this.state.currentOwner.password);
                debugger;
                company.getCompaniesOfOwner();
                company.getAllCompanies();
                debugger;
                window.location.assign("#/company-owner");
            }
            else
            {
                window.location.assign("#/");
            }
        })

    }

    addOwner()
    {
        this.restOwner.create(this.state.newOwner.username, this.state.newOwner.password);
    }
}

const owner = new Owner();

export default owner;