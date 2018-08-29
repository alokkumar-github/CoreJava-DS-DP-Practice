package conceptORproblem;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SherlockAndArray {

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//        final int N = s.nextInt();
//
//        for(int i = 0; i < N; i++) {
//            int NN = s.nextInt();
//            int[] arr = new int[NN];
//            for(int j = 0; j < NN; j++) {
//                arr[j] = s.nextInt();   
//            }
		int arr[] = {1,1,4,1,6,1,1,4,1};
            System.out.println(decision(Arrays.asList(1,1,4,1,1)));
        //}
	}
	// find an i, such that, A1+A2...Ai-1 = Ai+1+Ai+2...AN.
	public static String decision(List<Integer> arr){
        int sum = 0;
        for(int i=0; i<arr.size(); i++){
            sum += arr.get(i);
        }
        System.out.println("sum:: "+sum);
        //curr is cimulated sum in the left
        int curr = 0;
        for(int j=0; j<arr.size(); j++){
            //left part equals right part
        	System.out.println("dcu: "+curr);
        	System.out.println("dd: "+(sum - arr.get(j)-curr));
            if(curr == sum - arr.get(j)-curr){
                return "YES";
            }
            curr += arr.get(j);
        }
        return "NO";
    }

}
