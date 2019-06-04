
import transaction from "../Model/Transaction"

class TransactionPresenter
{
    changeProperties(property, value)
    {
        transaction.changeTransactionProperties(property, value);

    }

    onClickBuy()
    {
        transaction.addBuyTransaction();

    }

    onClickSale()
    {
        debugger;
        transaction.addSellTransaction();

    }

}


const transactionPresenter = new TransactionPresenter();

export default transactionPresenter;