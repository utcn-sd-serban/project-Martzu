import { EventEmitter} from "events";

class Transaction extends EventEmitter
{
    constructor()
    {
        super();
        this.state = {
            transactions : [],
            transactionsOfCurrentUser: [],
            newTransaction: {
                username: "",
                company: "",
                type: "",
                stockNumber: {},
                stockPrice: {},
                creationDate: {}
            }
        };
    }


    addBuyTransaction()
    {
        this.changeTransactionProperties("type", "b");
        this.state = {
            ...this.state,
            transactions : this.state.transactions.concat(this.state.newTransaction)
        };
        this.emit("change", this.state);

    }

    addSellTransaction()
    {
        this.changeTransactionProperties("type", "s");
        this.state = {
            ...this.state,
            transactions : this.state.transactions.concat(this.state.newTransaction)
        };
        this.emit("change", this.state);

    }

    changeTransactionProperties(property, value)
    {
        this.state = {
            ...this.state,
            newTransaction: {
                ...this.state.newTransaction, [property] : value
            }
        };
        this.emit("change", this.state);
    }

}
