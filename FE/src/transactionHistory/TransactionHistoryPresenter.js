
import transaction from "../Model/Transaction"

class TransactionHistoryPresenter
{

    getAllTransactions()
    {
        //transaction.getTransactionsOfUser();
        window.location.assign("#/transactions");
    }

}


const transactionHistoryPresenter = new TransactionHistoryPresenter();

export default transactionHistoryPresenter;