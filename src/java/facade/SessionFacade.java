/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import domain.Student;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SessionFacade {
    
    List<Student> getAll();
    void addStudent(String firstName, String lastName, int age);
    
}
