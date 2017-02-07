/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Student;
import facade.SessionFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SessionBean implements Serializable, SessionFacade{
    @PersistenceContext (name = "StudentWebApplicationPU")
    private EntityManager entityManager;
    
   
    public void addStudent(String firstName, String lastName, int age){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        entityManager.persist(student);
    }
    
    public List<Student> getAll(){
        Query query = entityManager.createQuery("SELECT s FROM Student as s");
        return query.getResultList();
        
        //
    }
}
