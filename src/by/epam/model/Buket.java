package by.epam.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.epam.utils.PriceComparator;

public class Buket {

	private String nameBuket;
	private double summa = 0;
	public static List<Plant> flowers = new ArrayList<Plant>(); 
	
	public Buket(String nameBuket) {
		this.nameBuket = nameBuket;
	}
	
	public  String getNameBuket() {
		return nameBuket;
	}

	public void setNameBuket(String nameBuket) {
		this.nameBuket = nameBuket;
	}
			
	public double getSumma(){
		return summa;
	}
	
	/*public double getSumma(List <Plant> flowers){
	for (Plant plant : flowers) {
	summa +=plant.getPrice();
	}
	return summa;
}*/
			
	/*public boolean addFlower(Plant plant) {
		return flowers.add(plant);
	}*/
	
	public Buket addFlower(Plant plant){
		flowers.add(plant);
		summa += plant.getPrice();
		return this;
	}
	
	public void showInfoBuket() {
		//File fpw = new File("showInfoBuket.txt");	
		try{
		FileWriter fw = new FileWriter(new File("showInfoBuket.txt"));
		if (flowers.isEmpty()) {
				//System.out.println("You haven't added any flowers yet!");
				fw.write("\n You haven't added any flowers yet!");
		}
		//System.out.println ("The Buket "+nameBuket+" contains:");
		fw.write("The Buket "+nameBuket+" contains:");
		for (Plant plant : flowers) {
			//System.out.println(plant.printInfo());
			fw.write("\n"+plant.printInfo());
		}
		//System.out.println("Total flowers in the buket "+ nameBuket +" = "+ flowers.size() + ". Summa = "+getSumma());
		//System.out.println("----------------------------");
		System.out.println("Find info in the file showInfoBuket.txt \n----------------------------");
		fw.write("\n Total flowers in the buket "+ nameBuket +" = "+ flowers.size() + ". Summa = "+getSumma());
		fw.write("\n ----------------------------");
		fw.flush();
		fw.close();
		} catch (IOException e) {
	       e.printStackTrace();
	    }
	}
		
	public static List<Plant> cloneList(List<Plant> flowers) {
	    List<Plant> cloneFlowers = new ArrayList<Plant>();
	    for(Plant item: flowers) 
	    	cloneFlowers.add(item);
	    return cloneFlowers;
	}
		
	public  void sortFlowerByFresh(){
		List<Plant> copyFlowers = (List<Plant>)cloneList(flowers);
		Collections.sort(copyFlowers);
		System.out.println("----------------------------");
		System.out.println("Flowers are sorted by freshness: ");
		for (Plant plant : copyFlowers){
			System.out.println (plant.printInfo());
		}
	}
	
	public void showFlowerByLength(int minLength, int maxLenght){
		int lengths;
		boolean i = false;
		System.out.println("----------------------------");
		System.out.println("Flowers with lengths ["+ minLength + ", " + maxLenght + "]");
		for (Plant plant : flowers){
			lengths = plant.getLength(); 
			if (lengths >= minLength && lengths <= maxLenght) {
				System.out.println (plant.printInfo());  
				i = true;
			}
		}
		if (i == false) System.out.println ("Sorry, no such flowers in the buket!");
	}
	
	public void sortFlowerByPrice(){
		try{
			FileWriter file = new FileWriter(new File("sortFlowerByPrice.txt"));
			List<Plant> copyFlowers = (List<Plant>)cloneList(flowers);
			Collections.sort(copyFlowers, new PriceComparator());
			file.write("Flowers are sorted by freshness: ");
			for (Plant plant : copyFlowers){
				file.write(plant.printInfo());
			}
			file.flush();
			file.close();
			System.out.println("Find info in the file sortFlowerByPrice.txt \n----------------------------");
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
