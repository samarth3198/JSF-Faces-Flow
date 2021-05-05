package fl.gov.dms.Department;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@FlowScoped("validate")
public class ValidateBean implements Serializable {

    public ValidateBean(){
    }

    private String key;

    public String getHomeAction(){
        return "/index";
    }

    public String checkKey(String pass) {
        System.out.println("Password is: " + pass);
        System.out.println("Key is: " + key);
        if(pass.equals(key)){
            return "validate2";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong key!", "You have entered a wrong key"));
            return null;
        }

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
