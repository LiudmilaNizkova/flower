package by.epam.model;

import by.epam.enumiration.Color;
import by.epam.enumiration.Freshness;
import by.epam.exception.LengthFlowerException;
import by.epam.exception.PriceFlowerException;

public class Pine extends Plant {
	
	public Pine(String name, int length, double price) {
		super(name, length, price);
		setCategory ("Pine");
	}

	public Pine (String name, int length, double price, Freshness fresh) {
		super(name, length, price, fresh);
		setCategory ("Pine");
	}
	
	public Pine (String name, int length, double price, Color color,
			Freshness fresh) throws PriceFlowerException, LengthFlowerException {
		super(name, length, price, color, fresh);
		setCategory ("Pine");
	}

}
