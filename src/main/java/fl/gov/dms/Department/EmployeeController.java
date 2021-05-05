package fl.gov.dms.Department;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EmployeeController{
    @PersistenceContext(unitName = "CRUD")
    EntityManager em;


    public void createEmployee(EmployeeEntity employeeEntity){
        em.persist(employeeEntity);
        //employeeController.getAll();
    }

    public List<EmployeeEntity> getAll() {
        Query query = em.createQuery("SELECT e FROM employees e");
        return  query.getResultList();
    }

    public void deleteEmployee(EmployeeEntity employeeEntity) {
        em.remove(em.merge(employeeEntity));
    }


    public void updateEmployee(EmployeeEntity employeeEntity) {
        em.merge(employeeEntity);
    }
}
