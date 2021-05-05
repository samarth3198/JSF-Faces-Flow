package fl.gov.dms.Department;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


@Named(value= "employee")
@RequestScoped
public class EmployeeBean implements Serializable {

    EmployeeEntity singleEmployee;
    List<EmployeeEntity> employees;

    @Inject
    private EmployeeController employeeController;

    @PostConstruct
    public void init(){
        employees = employeeController.getAll();
        singleEmployee = new EmployeeEntity();
    }

    public void create() throws IOException {
        employeeController.createEmployee(singleEmployee);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("viewdetails.xhtml");
    }

    public List<EmployeeEntity> getAllEmployees(){
        return employeeController.getAll();
    }

    public void delete(EmployeeEntity employeeEntity){
        employeeController.deleteEmployee(employeeEntity);
        employees = employeeController.getAll();
    }

    public void update(EmployeeEntity employeeEntity){

        employeeController.updateEmployee(employeeEntity);
    }

    //Getters and Setters method

    public EmployeeEntity getSingleEmployee() {
        return singleEmployee;
    }

    public void setSingleEmployee(EmployeeEntity singleEmployee) {
        this.singleEmployee = singleEmployee;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
