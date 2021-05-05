package fl.gov.dms.Department;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped("signup")
public class SignupBean implements Serializable {
    private boolean terms;

    private static final long serialVersionUID = 1L;
    public SignupBean(){

    }

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getHomeAction() {
        return "/index";
    }

    public boolean isTerms(){
        return terms;
    }

    public void setTerms(boolean terms) {
        this.terms = terms;
    }

    public String accept(){
        if(this.terms){
            return "signup3";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please accept the terms and click on the box","Please accept the terms and click on the box" ));
            return null;
        }
    }
}
