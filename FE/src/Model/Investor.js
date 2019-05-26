import { EventEmitter} from "events";

class Investor extends EventEmitter
{
    constructor()
    {
        super();
        this.state =
            {
              investors: [
                  {
                  username: "ME",
                  password: "ME",
                  capital: 1000
                  }
              ],
              currentInvestor: {
                  username: "",
                  password: "",
                  capital: {}
              },
              newInvestor: {
                  username: "",
                  password: "",
                  capital: 5000
              }
            };
    }

    changeNewInvestor(property, value)
    {
        this.state = {
            ...this.state,
            newInvestor: {
                ...this.state.newInvestor, [property] : value
            }
        };

        this.emit("change", this.state);
    }

    changeCurrentInvestor(property, value)
    {
        this.state = {
            ...this.state,
            currentInvestor: {
                ...this.state.currentInvestor, [property] : value
            }
        };
        this.emit("change", this.state);
    }

    //in memory, different login for frontEnd to backEnd
    verifyInvestor()
    {
        debugger;
        const result = this.state.investors.find(investor => investor.username === this.state.currentInvestor.username && investor.password === this.state.currentInvestor.password);
        debugger;
        if (typeof result === 'undefined')
        {
            //set window
            window.location.assign("#/");
        }
        else
        {
            window.location.assign("#/company");
        }
    }

    addInvestor()
    {
        this.state = {
            ...this.state,
            investors : this.state.investors.concat(this.state.newInvestor)
        };

        this.emit("change", this.state);
    }


}

const investor = new Investor();

export default investor;