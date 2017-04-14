package ds.array;

import java.util.Arrays;
import java.util.Comparator;

class GameEntry{
	private int score;
	private String name;
	GameEntry(int scroe,String name){
		this.score=scroe;
		this.name=name;
	}
	public int getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "GameEntry [score=" + score + ", name=" + name + "]";
	}
	
}
public class ArrayDemo {
	
	GameEntry[] entries;
	ArrayDemo(int capcity){
		this.entries=new GameEntry[capcity];
	}
	private void addToArray(GameEntry entry){
		
		for(int i=0;i<this.entries.length;i++){
			this.entries[i]=entry;
		}
		this.entries[10]=new GameEntry(500, "Aichal");
		Arrays.sort(entries,new Comparator<GameEntry>() {
						@Override
						public int compare(GameEntry o1, GameEntry o2) {
							return o1.getName().compareTo(o2.getName());
						}
					}
				);
		System.out.println(Arrays.toString(entries));
		
	}
	
	private static void AddElementToArrayAndSwiftIndex(int orignalArray[],int positionOfElement,int elementToBeInserted){
		int resultArray[]=new int[orignalArray.length+1];
		for(int i=0;i<positionOfElement;i++){
			resultArray[i]=orignalArray[i];
		}
		resultArray[positionOfElement]=elementToBeInserted;
		for(int j=positionOfElement+1;j<resultArray.length;j++){
			resultArray[j]=orignalArray[j-1];
		}
		System.out.println(Arrays.toString(resultArray));
	}
	private static void removeElementToArrayAndSwiftIndex(int orignalArray[],int element){
		int resultArray[] =new int[orignalArray.length-1];
		int index=0;
		for(int i=0;i<orignalArray.length;i++){
			if(orignalArray[i]==element){
				index=i;
				orignalArray[i]=orignalArray[i+1];
			}
		}
		for(int i=index;i<orignalArray.length-1;i++){
			int temp=orignalArray[i+1];
			orignalArray[i]=temp;
		}
		for(int i=0;i<orignalArray.length-1;i++){
			resultArray[i]=orignalArray[i];
		}
		System.out.println(Arrays.toString(resultArray));
		
	}
	private static void copyOfArray(){
		int []i=new int[]{3,5,7,9,10};
		int []copy=Arrays.copyOf(i, i.length);
		int []copyRange=Arrays.copyOfRange(i, 0, 2);
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(copyRange));
	}
	private static void  findMinAndMaxInArray(){
		int []i={2,9,1,65,159,0,45};
		int minValue=Integer.MAX_VALUE;
		int maxValue=Integer.MIN_VALUE;
		System.out.println("InitialminValue="+minValue);
		System.out.println("InitialmaxValue="+maxValue);
		for(int j=0;j<i.length;j++){
			if(i[j]<minValue){
				minValue=i[j];
			}
			if(i[j]>maxValue){
				maxValue=i[j];
			}
		}
		System.out.println("minValue="+minValue);
		System.out.println("maxValue="+maxValue);
	}

	public static void main(String[] args) {
		removeElementToArrayAndSwiftIndex(new int[]{2,4,8,10,880,9},8);
		AddElementToArrayAndSwiftIndex(new int[]{2,4,8,10},2,88);
		copyOfArray();
		findMinAndMaxInArray();
		ArrayDemo ad=new ArrayDemo(20);
		ad.addToArray(new GameEntry(1200, "jone"));
		
		
		
		
		// Declare and Initialization of array.
		int i1[]={2,5,6,7};
		int[] i2=new int[]{1,2,5,6};
		String []s;
		s=new String[3];
		for(int i=0;i<s.length;i++){
			s[i]="A"+i;
		}
		
		// Accessing the array element.
		int i=i1[1];
		for(int j=0;j<s.length;j++){
			System.out.println(s[j]);
		}
		// or for each loop.
		
		for(String ii:s){
			System.out.println(ii);
		}
		
		// Array length
		int length=s.length;
		System.out.println("length of array s = "+length);
		

	}

}
