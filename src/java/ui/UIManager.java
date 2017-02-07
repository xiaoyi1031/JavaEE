
package ui;

import domain.Student;
import facade.SessionFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UIManager implements Serializable{
    private String firstName;
    private String lastName;
    private int age;
    private String output;
    @Inject
    private SessionFacade facade;
    
    public void submit(){
      
        facade.addStudent(firstName, lastName, age);
        //output = firstName + " " + lastName + " Submitted";
    }
    public UIManager(){
    }

    
    public String getOutput() {
        
        output = "";
        List<Student> result = facade.getAll();
        for (Student s : result){
            output += s.getId() + ":" + s.getFirstName() + " " + s.getLastName()+ " is " + s.getAge() + ";";
        }
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
