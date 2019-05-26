import investor from "../Model/Investor";

class CompanyPresenter
{
    logout()
    {
        investor.changeCurrentInvestor("username", "");
        investor.changeCurrentInvestor("password", "");
        window.location.assign("#/");
    }
}

const companyPresenter = new CompanyPresenter();

export default companyPresenter;