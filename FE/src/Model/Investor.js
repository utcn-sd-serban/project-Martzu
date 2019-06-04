import { EventEmitter} from "events";
import RestInvestor from "../rest/restInvestor";
import ownedStocks from "./OwnedStocks";
import transaction from "./Transaction";
import company from "./Company";
class Investor extends EventEmitter
{
    constructor()
    {
        super();
        this.restInvestor = new RestInvestor();
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

    verifyInvestor()
    {
        this.restInvestor.setUser(this.state.currentInvestor.username, this.state.currentInvestor.password);

        this.restInvestor.login().then(response =>{
            if (response.status === 200)
            {
                company.getAllCompanies();
                ownedStocks.getStocksOfInvestor();
                transaction.getTransactionsOfUser();
                window.location.assign("#/company");
            }
            else
            {
                window.location.assign("#/");
            }
        });

    }




    addInvestor()
    {
        debugger;
        return this.restInvestor.create(this.state.newInvestor.username, this.state.newInvestor.password)
            .then(investor => {
                this.state = {
                    ...this.state,
                    investors: this.state.investors.concat([investor])
                };
                this.emit("change", this.state);
            });

    }


}

const investor = new Investor();

export default investor;