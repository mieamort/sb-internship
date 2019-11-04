package payroll.controller.tmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class ClassA {
    private ClassB b;
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setB(ClassB b) {

    }
}
