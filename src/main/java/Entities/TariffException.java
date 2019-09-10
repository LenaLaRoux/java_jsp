package Entities;

public class TariffException extends  Exception {
    public TariffException (String message){
        super(message);
    }
    public TariffException(String message , Throwable cause){
        super(message, cause);
    }
}
