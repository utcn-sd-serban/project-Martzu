
import investor from "../Model/Investor"

class CreateInvestorPresenter
{
    changeProperties(property, value)
    {
        investor.changeNewInvestor(property,value);
    }

    onClick()
    {
        investor.addInvestor();
        investor.changeNewInvestor("username", "");
        investor.changeNewInvestor("password", "");
        window.location.assign("#/");
    }
}

const createInvestorPresenter = new CreateInvestorPresenter();

export default createInvestorPresenter;