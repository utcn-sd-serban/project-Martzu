import company from "../Model/Company";

class PerformActionPresenter
{
    onChange(property, value)
    {
        company.changeSplitProperty(property, value);
    }

    onClick()
    {
        debugger;
        company.performSplit();
        company.changeSplitProperty("split", "");
        company.changeSplitProperty("companyToSplit", "");
        window.location.assign("#/company-owner");
    }


}

const performActionPresenter = new PerformActionPresenter();

export default performActionPresenter;