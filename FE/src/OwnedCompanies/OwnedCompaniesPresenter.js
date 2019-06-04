import company from "../Model/Company";

class OwnedCompaniesPresenter
{
    onClick()
    {
        window.location.assign("#/owned-companies");

    }
}

const ownedCompaniesPresenter = new OwnedCompaniesPresenter();

export default ownedCompaniesPresenter;