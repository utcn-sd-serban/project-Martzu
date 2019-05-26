import { EventEmitter} from "events";

class Company extends EventEmitter {
    constructor() {
        //company has a String owner
        //passed from the backend
        super();
        this.state = {
            companies: [],
            newCompany: {
                owner: "",
                name: "",
                tag: "",
                shares: {},
                sharePrice: {}
            },

            companiesOfCurrentOwner: []
        }

    }

    changeNewCompanyProperty(property, value)
    {
        this.state = {
            ...this.state,
            newCompany : {
                ...this.state.newCompany, [property] : value
            }
        };

        this.emit("change", this.state);
    }

    addCompany()
    {
        this.state = {
            ...this.state,
            companies : this.state.companies.concat(this.state.newCompany)
        };
    }

    getCompaniesOfOwner(username)
    {
        const ownedCompanies = this.state.companies.filter(company => company.owner === username);
        this.state = {
            ...this.state,
            companiesOfCurrentOwner : ownedCompanies
        };
    }

    //TODO load all companies from back-end, add split

}

