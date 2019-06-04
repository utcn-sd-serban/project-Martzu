import company from "../Model/Company";

class AddCompanyPresenter
{
    onChange(property, value)
    {
        company.changeNewCompanyProperty(property, value);
    }

    onClick()
    {
        company.addCompany();
        company.changeNewCompanyProperty("owner", "");
        company.changeNewCompanyProperty("name", "");
        company.changeNewCompanyProperty("tag", "");
        company.changeNewCompanyProperty("sharePrice", "");
        company.changeNewCompanyProperty("evaluation", "");
        window.location.assign("#/company-owner");

    }
}

const addCompanyPresenter = new AddCompanyPresenter();

export default addCompanyPresenter;