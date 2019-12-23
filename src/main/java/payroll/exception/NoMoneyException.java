package payroll.exception;

public class NoMoneyException extends RuntimeException {
    public NoMoneyException(){super("Нехватает денег");}
}
