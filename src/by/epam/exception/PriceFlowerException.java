package by.epam.exception;

public class PriceFlowerException extends Exception {
	
	private double detailPrice;
	
	public PriceFlowerException (double a) {
		detailPrice = a;
	}
		
	public String toString(){
		return "Price cannot be negative. You set price =  "+detailPrice;
	}
	
}
