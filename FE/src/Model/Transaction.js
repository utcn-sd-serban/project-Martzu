import { EventEmitter} from "events";
import RestTransaction from "../rest/restTransactions";
import investor from "../Model/Investor";
import ownedStocks from "../Model/OwnedStocks";
import company from "../Model/Company";

class Transaction extends EventEmitter
{
    constructor()
    {
        super();
        this.restTransaction = new RestTransaction();
        this.state = {
            transactionsOfCurrentUser: [],
            newTransaction: {
                username: "",
                company: "",
                stockNumber: {}
            }
        };
    }



    updateTransactionAndOwnedStocks()
    {
        this.getTransactionsOfUser();
        ownedStocks.getStocksOfInvestor();
    }

    getTransactionsOfUser()
    {
        this.restTransaction.setUser(investor.state.currentInvestor.username, investor.state.currentInvestor.password);
        this.restTransaction.getAllTransactionsOfUser().then(transactions => {
            this.state = {
                ...this.state,
                transactionsOfCurrentUser: transactions
            }
        });
        this.emit("change", this.state);
    }

    addBuyTransaction()
    {
        debugger;
        this.restTransaction.setUser(investor.state.currentInvestor.username, investor.state.currentInvestor.password);
        this.state = {
            ...this.state,
            newTransaction:{
                ...this.state.newTransaction, "username" : investor.state.currentInvestor.username
            }
        };
        this.state.newTransaction.username = investor.state.currentInvestor.username;
        if(this.state.newTransaction.company.length < 4)
        {
            this.restTransaction.placeBuyTransactionByTag(investor.state.currentInvestor.username, this.state.newTransaction.company, this.state.newTransaction.stockNumber).then(
                response => {
                    if(response.status === 200)
                    {
                        this.updateTransactionAndOwnedStocks();
                        company.getAllCompanies();
                        window.location.assign("#/company");
                    }
                    else
                    {
                        window.location.assign("#/place-transaction");
                    }
                }
            );
        }
        else
        {
            this.restTransaction.placeBuyTransactionByName(investor.state.currentInvestor.username, this.state.newTransaction.company, this.state.newTransaction.stockNumber).then(
                response => {
                    if(response.status === 200)
                    {
                        this.updateTransactionAndOwnedStocks();
                        company.getAllCompanies();
                        window.location.assign("#/company");
                    }
                    else
                    {
                        window.location.assign("#/place-transaction");
                    }
                }

            );
        }
        this.emit("change", this.state);
    }

    addSellTransaction()
    {
        this.restTransaction.setUser(investor.state.currentInvestor.username, investor.state.currentInvestor.password);
        this.state = {
            ...this.state,
            newTransaction:{
                ...this.state.newTransaction, "username" : investor.state.currentInvestor.username
            }
        };
        this.state.newTransaction.username = investor.state.currentInvestor.username;
        if(this.state.newTransaction.company.length < 4)
        {
            this.restTransaction.placeSellTransactionByTag(investor.state.currentInvestor.username, this.state.newTransaction.company, this.state.newTransaction.stockNumber).then(
                response => {
                    if(response.status === 200)
                    {
                        this.updateTransactionAndOwnedStocks();
                        company.getAllCompanies();
                        window.location.assign("#/company");
                    }
                    else
                    {
                        window.location.assign("#/place-transaction");
                    }
                }

            );
        }
        else
        {
            this.restTransaction.placeSellTransactionByName(investor.state.currentInvestor.username, this.state.newTransaction.company, this.state.newTransaction.stockNumber).then(
                response => {
                    if(response.status === 200)
                    {
                        this.updateTransactionAndOwnedStocks();
                        company.getAllCompanies();
                        window.location.assign("#/company");
                    }
                    else
                    {
                        window.location.assign("#/place-transaction");
                    }
                }

            );
        }

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

const transaction = new Transaction();

export default transaction;
