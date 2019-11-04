package payroll.exeption;

public class EmployeeNameLengthException extends RuntimeException {

    public EmployeeNameLengthException() {
        super("Name is too long. Max name lenght = 15");
    }
}
