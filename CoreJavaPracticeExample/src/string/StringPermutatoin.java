package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StringPermutatoin {

	public static void main(String[] args) {
		
		String str="MAN";
		char[]c=str.toCharArray();
		int initialIndex=0;
		int lastIndex=str.length()-1;
		System.out.println(crunchifyPermutation(str));
		//strPermutation(c, initialIndex, lastIndex);
	}

	public static Set<String> crunchifyPermutation(String str) {
		Set<String> crunchifyResult = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			crunchifyResult.add("");
			return crunchifyResult;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		System.out.println("rem\t"+rem);
		Set<String> words = crunchifyPermutation(rem);
		System.out.println("words\t"+words);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				crunchifyResult.add(crunchifyCharAdd(newString, firstChar, i));
			}
		}
		System.out.println("retrun crunchifyResult\t"+crunchifyResult);
		return crunchifyResult;
	}
 
	public static String crunchifyCharAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		String temp=first + c + last;
		System.out.println(temp);
		return temp;
	}
}


/**
 *https://www.youtube.com/watch?v=nYFd7VHKyWQ&t=1173s
 *https://www.educative.io/page/11000001/90001
 * Generate all permutations of string in lexicographically sorted order where repetitions of
 * character is possible in string.
 */
class StringPermutation1 {

    public List<String> permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
    }

    public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }

    private void printArray(char input[]) {
        for(char ch : input) {
            System.out.print(ch);
        }
        System.out.println();
    }
   // https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                System.out.println("str:: "+str);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String args[]) {
        StringPermutation1 sp = new StringPermutation1();
        //sp.permute("AABC".toCharArray()).forEach(s -> System.out.println(s));
        
        String str = "ABC";
        int n = str.length();
        sp.permute(str, 0, n-1);
    }
}
