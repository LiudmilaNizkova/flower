package by.epam.utils;

import java.util.Comparator;
import by.epam.model.Plant;


public abstract class SortComparator implements Comparator<Plant>{

	public int compare(Plant p1, Plant p2){
		return p1.getFresh().compareTo(p2.getFresh());
	}
	
	
}
