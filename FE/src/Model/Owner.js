import { EventEmitter} from "events";

class Owner extends EventEmitter
{
    constructor()
    {
        super();
        this.state = {
            owners : [],
            newOwner:{
                username: "",
                password: ""
            }
        };
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

    addOwner()
    {
        this.state = {
            ...this.state,
            owners : this.state.owners.concat(this.state.newOwner)
        };
        this.emit("change", this.state);
    }
}