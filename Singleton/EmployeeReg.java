package Singleton;

import java.util.ArrayList;
import java.util.List;

//When?
//when we need only a single instance of a class as a single source of truht
//we dont want to do eager initialization, only lazy initialization
//why is it a bad idea to have a static variable instead?
// 1. Static variable: Gets initialized when the class is first loaded — you have little control over when that happens.
//2 . Static variables are globally available and often globally mutable.
public class EmployeeReg {
    private static EmployeeReg instance=null;
    private final List<String> employees = new ArrayList<>();
    private EmployeeReg() {
        employees.add("John Doe");
        employees.add("Jane Doe");
        employees.add("Jack Doe");
    }
    //synchronise for thread saftey so that we dont create multiple instances
    public synchronized static EmployeeReg getInstance() {
        if(instance == null) {
            instance = new EmployeeReg();
            return instance;
        }
        else{
            return instance;
        }
    }
    public List<String> getEmployees() {
        return new ArrayList<>(employees); // return copy to prevent external modification
    }
}
