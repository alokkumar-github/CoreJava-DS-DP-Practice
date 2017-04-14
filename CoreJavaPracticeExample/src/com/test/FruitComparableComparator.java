package com.test;

import java.util.Arrays;
import java.util.Comparator;

public class FruitComparableComparator implements Comparable<FruitComparableComparator>{
	
	private String fruitName;
	private String fruitDesc;
	private int quantity;
	
	public FruitComparableComparator(String fruitName, String fruitDesc, int quantity) {
		super();
		this.fruitName = fruitName;
		this.fruitDesc = fruitDesc;
		this.quantity = quantity;
	}
	
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public String getFruitDesc() {
		return fruitDesc;
	}
	public void setFruitDesc(String fruitDesc) {
		this.fruitDesc = fruitDesc;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int compareTo(FruitComparableComparator compareFruit) {
	
		int compareQuantity = ((FruitComparableComparator) compareFruit).getQuantity(); 
		
		//ascending order
		return this.quantity - compareQuantity;
		
		//descending order
		//return compareQuantity - this.quantity;
		
	}
	
	public static Comparator<FruitComparableComparator> FruitNameComparator 
                          = new Comparator<FruitComparableComparator>() {

	    public int compare(FruitComparableComparator fruit1, FruitComparableComparator fruit2) {
	    	
	      String fruitName1 = fruit1.getFruitName().toUpperCase();
	      String fruitName2 = fruit2.getFruitName().toUpperCase();
	      
	      //ascending order
	      return fruitName1.compareTo(fruitName2);
	      
	      //descending order
	      //return fruitName2.compareTo(fruitName1);
	    }

	};
	public static void main(String str[]){
		FruitComparableComparator[] fruits = new FruitComparableComparator[4];
		
		FruitComparableComparator pineappale = new FruitComparableComparator("Pineapple", "Pineapple description",70); 
		FruitComparableComparator apple = new FruitComparableComparator("Apple", "Apple description",100); 
		FruitComparableComparator orange = new FruitComparableComparator("Orange", "Orange description",80); 
		FruitComparableComparator banana = new FruitComparableComparator("Banana", "Banana description",90); 
		
		fruits[0]=pineappale;
		fruits[1]=apple;
		fruits[2]=orange;
		fruits[3]=banana;
		Arrays.sort(fruits, FruitComparableComparator.FruitNameComparator);
		//Arrays.sort(fruits);
		int i=0;
		for(FruitComparableComparator temp: fruits){
		   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}
		}
}
