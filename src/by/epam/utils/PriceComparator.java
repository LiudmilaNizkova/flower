package by.epam.utils;

import java.util.Comparator;

import by.epam.model.Plant;

public class PriceComparator implements Comparator <Plant>{

	public int compare(Plant p1, Plant p2){
		//return (int) (p2.getPrice() - p1.getPrice());
		return Double.compare(p2.getPrice(), p1.getPrice()); 
	}

}
