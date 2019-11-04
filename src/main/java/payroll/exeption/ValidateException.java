package payroll.exeption;

public class ValidateException extends RuntimeException{
    public ValidateException (){
        super("Пользователь с таким именем уже существует!");
    }
}
