package by.epam.model;

import by.epam.enumiration.Color;
import by.epam.enumiration.Freshness;
import by.epam.exception.LengthFlowerException;
import by.epam.exception.PriceFlowerException;
import by.epam.utils.SortComparator;

public class Plant implements Comparable <Plant>{
	
	private final String name;      
	private String category;
	private int  length;		
	private double price;	
	//private float price;
	private Color color;		
	private Freshness fresh; 

	
	public Plant (String name){
		this.name = name;
	}
	
	public Plant (String name, int length, double price){
		if (price < 0){
			throw new IllegalArgumentException ("Price cannot be less than 0");
		}
		if (length <= 0){
			throw new IllegalArgumentException ("Length cannot be negative number or equals 0");
		}
		this.name = name;
		this.length = length;
		this.price = price;
		this.color = Color.Green;
		this.fresh = Freshness.FullFresh;
	}
	
	public Plant (String name, int length, double price, Freshness fresh){
		if (price < 0){
			throw new IllegalArgumentException ("Price cannot be less than 0");
		}
		if (length <= 0){
			throw new IllegalArgumentException ("Length cannot be negative number or equals 0");
		}
		this.name = name;
		this.length = length;
		this.price = price;
		this.fresh = fresh;
		this.color = Color.Green;
	}
	
	public Plant(String name, int length, double price, Color color,
			Freshness fresh) throws PriceFlowerException, LengthFlowerException {
		if (price < 0){
			throw new PriceFlowerException (price);
		}
		/*if (length <= 0){
			throw new IllegalArgumentException ("Length cannot be negative number or equals 0");
		}*/
		if (length <= 0){
			throw new LengthFlowerException (length);
		}
			
		this.name = name;
		this.length = length;
		this.price = price;
		this.color = color;
		this.fresh = fresh;
	}
		
	public String printInfo() {
		return ("Flower name - "+getName()+" (" + getCategory() + ")"+"; Color - "+getColor()+"; Fresh -"+getFresh()
		+"; Length - "+getLength()+"; Price - "+getPrice());
	}
	
	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLength() {
		return length;
	}

	/*public void setLength(int length) {
		this.length = length;
	}*/
	
	public void setLength(int length) throws LengthFlowerException {
		this.length = length;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(float price) throws PriceFlowerException  {
		this.price = price;
		
	}
	/*public void setPrice(float price){
		this.price = price;
	}*/

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Freshness getFresh() {
		return fresh;
	}

	public void setFresh(Freshness fresh) {
		this.fresh = fresh;
	}

	@Override
	public int compareTo(Plant p) {
		int result = this.fresh.compareTo(p.getFresh());
		return result;
	}
	
	
}
