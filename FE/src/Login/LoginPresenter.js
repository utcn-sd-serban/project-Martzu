import investor from "../Model/Investor"

class LoginPresenter
{
    changeLoginProperties(property, value)
    {
        investor.changeCurrentInvestor(property, value);
    }

    verifyUser()
    {
        investor.verifyInvestor();
    }

    changeCreateAccount()
    {
        window.location.assign("#/create-investor");
    }
}

const loginPresenter = new LoginPresenter();

export default loginPresenter;