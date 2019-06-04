
import owner from "../Model/Owner"

class CreateOwnerPresenter
{
    changeProperties(property, value)
    {
        owner.changeNewOwnerProperties(property, value);
    }

    onClick()
    {
        owner.addOwner();//add function
        owner.changeNewOwnerProperties("username", "");
        owner.changeNewOwnerProperties("password", "");
        window.location.assign("#/");
    }

}


const createOwnerPresenter = new CreateOwnerPresenter();

export default createOwnerPresenter;