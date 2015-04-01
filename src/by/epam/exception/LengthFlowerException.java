package by.epam.exception;

public class LengthFlowerException extends Exception{

private double detailLength;
	
	public LengthFlowerException (double a) {
		detailLength = a;
	}
		
	public String toString(){
		return "Lenght cannot be negative or equals 0. You set price =  "+detailLength+". Please try again!";
	}
}
