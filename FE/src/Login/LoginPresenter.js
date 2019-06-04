import investor from "../Model/Investor"
import owner from "../Model/Owner"
class LoginPresenter
{
    changeLoginProperties(property, value)
    {
        investor.changeCurrentInvestor(property, value);
        owner.changeCurrentOwnerProperties(property, value);
    }

    verifyUser()
    {
        investor.verifyInvestor();
    }



    changeCreateInvestor()
    {
        window.location.assign("#/create-investor");
    }

    changeCreateOwner()
    {
        window.location.assign("#/create-owner");
    }

    verifyOwner()
    {
        owner.verifyUser();
    }
}

const loginPresenter = new LoginPresenter();

export default loginPresenter;