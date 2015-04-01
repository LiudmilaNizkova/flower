package by.epam.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.epam.enumiration.Color;
import by.epam.enumiration.Freshness;
import by.epam.exception.LengthFlowerException;
import by.epam.exception.NameFlowerException;
import by.epam.exception.PriceFlowerException;
import by.epam.model.Buket;
import by.epam.model.Flower;
import by.epam.model.Pine;
import by.epam.model.Plant;


public class Main {

	public static int minLength, maxLength, action;
	public static String nameFlower = "";
	
	public static void main(String[] args) throws NameFlowerException, PriceFlowerException, LengthFlowerException {
		boolean repeat = true;
		Buket buket1 = new Buket("Origin");
		
		try {
			Plant rose1 = new Flower("Rosa", -50, -10000, Color.White, Freshness.OldFresh);
			buket1.addFlower(rose1);
		} catch (PriceFlowerException e1) {
			e1.printStackTrace();
		}
		catch (LengthFlowerException e2){
			e2.printStackTrace();
		}
		try {
			Plant rose2 = new Flower("Rosa", -50, 10000, Color.White, Freshness.OldFresh);
			buket1.addFlower(rose2);
		} catch (PriceFlowerException e1) {
			e1.printStackTrace();
		}
		catch (LengthFlowerException e2){
			e2.printStackTrace();
		}
		
		try {
			Plant rose3 = new Flower("Rosa", 50, 10000, Color.White, Freshness.OldFresh);
			buket1.addFlower(rose3);
		} catch (PriceFlowerException e1) {
			e1.printStackTrace();
		}
		catch (LengthFlowerException e2){
			e2.printStackTrace();
		}
		
		try {
			Plant mimoza = new Flower ("Mimoza", 30, 15000, Color.Yellow, Freshness.FullFresh);
			buket1.addFlower(mimoza);
		} catch (PriceFlowerException e1) {
			e1.printStackTrace();
		}
		catch (LengthFlowerException e2){
			e2.printStackTrace();
		}
		try {
			Plant rose2 = new Flower ("Rosa", 100, 20000, Color.Red, Freshness.MiddleFresh);
			buket1.addFlower(rose2);
		} catch (PriceFlowerException e1) {
			e1.printStackTrace();
		} 
		catch (LengthFlowerException e2){
			e2.printStackTrace();
		}
		Plant vetka1 = new Pine ("Vetka", 50, 10000, Freshness.OldFresh);
		Plant list1 = new Pine("Leaf", 60, 5000, Color.Yellow, Freshness.FullFresh);
		buket1.addFlower(vetka1).addFlower(list1);
		Scanner in  = new Scanner (System.in);
		
		while (repeat){
			System.out.println("1. Show info buket");
			System.out.println("2. Sort flowers by freshness");
			System.out.println("3. Show flowers by lenght");
			System.out.println("4. Show flowers by price");
			System.out.println("5. Find flower by Name");
			System.out.println("0. Exit");
			
			action = in.nextInt();
			
			switch (action){
			case 1: 
				buket1.showInfoBuket();
				//System.out.println("Find info in the file showInfoBuket.txt \n----------------------------");
				break;
				
			case 2:
				buket1.sortFlowerByFresh();
				break;
				
			case 3:
				try {
					 Scanner tt = new Scanner(new File("infoLength.txt"));
			         List<String> lines = new ArrayList<String>();
			         while (tt.hasNextLine()){	
			        	lines.add(tt.nextLine()); 
			         }
			         tt.close();
			         String [] numbers = lines.toArray(new String[lines.size()]);
			        	 try {
			        		 	minLength = Integer.parseInt(numbers[0]);
			        		 	maxLength = Integer.parseInt(numbers[1]);
			        		 	//System.out.println("minLength = "+minLength+" maxLength = "+maxLength);
			                } 
			        	 	catch (NumberFormatException e) {
			                    System.out.println("Incorrect symbol in the number "+e);
			                }
			        	 	catch (NegativeArraySizeException e){
			        	 		System.out.println("Incorrent buffer size "+e);
			        	 	}
			        	 buket1.showFlowerByLength(minLength, maxLength);
			         
				 } catch (IOException e) {
						System.out.println("Cannot find file");
						System.out.println(e.getMessage());
						//e.printStackTrace();
				    }
				finally {
					if (minLength == 0 && maxLength ==0){
					System.out.println("\n----------------------------"+"" +
							" \n Please create file infoLength.txt and try again! \n----------------------------");
					}
				}
				/*System.out.println ("Enter min length of Flower in the buket ");
				minLength = (int) in.nextDouble();
				System.out.println ("Enter max length of Flower in the buket ");
				maxLength = (int) in.nextDouble();
				buket1.showFlowerByLength(minLength, maxLength);*/
				break;
				
			case 4:
				buket1.sortFlowerByPrice();
				break;
				
			case 5:
				Scanner nn  = new Scanner (System.in);
				System.out.println("Enter Name of flower");		
				nameFlower = nn.nextLine();
				try{
					BufferedReader reader = new BufferedReader(new FileReader("infoBuket.txt"));
					String line;
					List<String> lines = new ArrayList<String>();
					while ((line = reader.readLine()) != null){
			            lines.add(line);
					}
					String [] names = lines.toArray(new String[lines.size()]);
					reader.close();
					boolean a = false;
					for (int i=0; i < names.length; i++){
					if (names[i].equals(nameFlower)){
						System.out.println("Buket = "+buket1.getNameBuket()+" contains flower - "+nameFlower);
						a= true;
						}
					}	
					if (a == false) {
						throw new NameFlowerException ("Buket doesn't contain flower "+nameFlower);
					}
										
				} catch (IOException e) {
					System.out.println("Cannot find file");
					System.out.println(e.getMessage());
					//e.printStackTrace();
				}
				break;
				
			case 0:
				repeat = false;
				System.out.println("Exit!");
				break;
				
			default: 
				System.out.println("Incorrect value! Please, try again!");
				break;
				
			}
			
		}
		in.close();
	}
}
