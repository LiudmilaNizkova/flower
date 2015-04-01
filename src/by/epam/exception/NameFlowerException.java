package by.epam.exception;

public class NameFlowerException extends Exception {
		
	public NameFlowerException(){
		
	}
	
	public NameFlowerException(String message, Throwable exception){
		super(message, exception);
	}
	
	public NameFlowerException(String message){
		super(message);
	}
	
	public NameFlowerException(Throwable exception){
		super(exception);
	}
	
}
