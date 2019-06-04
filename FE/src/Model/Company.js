import { EventEmitter} from "events";
import RestCompany from "../rest/restCompany";
import investor from "../Model/Investor";
import owner from "../Model/Owner"
class Company extends EventEmitter {
    constructor() {
        //company has a String createOwner
        //passed from the backend
        super();
        this.restCompany = new RestCompany();
        this.state = {
            companies: [],
            newCompany: {
                owner: "",
                name: "",
                tag: "",
                sharePrice: "",
                evaluation: ""
            },

            companiesOfCurrentOwner: [],
            split: "",
            companyToSplit: ""
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

    changeSplitProperty(property, value)
    {
        this.state = {
            ...this.state, [property] : value
        };
        this.emit("change", this.state);
    }


    performSplit()
    {
        debugger;
        this.restCompany.split(this.state.split, this.state.companyToSplit);
        this.getCompaniesOfOwner();
        this.getAllCompanies();
    }


    addCompany()
    {

        debugger;
        this.restCompany.addCompany(this.state.newCompany);
        this.getCompaniesOfOwner();
        this.getAllCompanies();
        debugger;

    }

    getCompaniesOfOwner()
    {
        this.restCompany.setUser(owner.state.currentOwner.username, owner.state.currentOwner.password);
        this.restCompany.getCompaniesOfOwner().then(companies =>{
            this.state = {
                ...this.state,
                companiesOfCurrentOwner:  companies
            };
            this.emit("change", this.state);
            });
    }

    getAllCompanies()
    {
        debugger;
        this.restCompany.setUser(investor.state.currentInvestor.username, investor.state.currentInvestor.password);
        this.restCompany.getAllCompanies().then(allCompanies =>{
            this.state = {
                ...this.state,
                companies : allCompanies
            };
            this.emit("change", this.state);
            debugger;
        });
    }


}

const company = new Company();

export default company;