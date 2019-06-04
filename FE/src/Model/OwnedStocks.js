import { EventEmitter} from "events";
import RestOwnedStocks from "../rest/restOwnedStocks";
import investor from "../Model/Investor";
class OwnedStocks extends EventEmitter
{
    constructor()
    {
        super();
        this.restOwnedStocks = new RestOwnedStocks();
        this.state = {
            ownedStocks: []
        };
    }



    getStocksOfInvestor()
    {
        debugger;
        this.restOwnedStocks.setUser(investor.state.currentInvestor.username, investor.state.currentInvestor.password);
        this.restOwnedStocks.getOwnedStocks().then(stocks =>{
            this.state = {
                ...this.state,
                ownedStocks : stocks
            }
        });
        this.emit("change",this.state);
    }
}

const ownedStocks = new OwnedStocks();

export default ownedStocks;
