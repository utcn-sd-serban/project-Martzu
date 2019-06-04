
import ownedStocks from "../Model/OwnedStocks"

class OwnedStocksPresenter
{

    onClick()
    {
        debugger;
        window.location.assign("#/owned-stocks");
        //ownedStocks.getStocksOfInvestor();
    }
}


const ownedStocksPresenter = new OwnedStocksPresenter();

export default OwnedStocksPresenter;