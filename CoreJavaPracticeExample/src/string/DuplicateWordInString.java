package string;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class DuplicateWordInString
{
    static void DuplicateWordInString(String inputString)
    {
        //Splitting inputString into words
 
        String[] words = inputString.split(" ");
 
        //Creating one HashMap with words as key and their count as value
 
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
 
        //Checking each word
 
        for (String word : words)
        {
            //whether it is present in wordCount
 
            if(wordCount.containsKey(word.toLowerCase()))
            {
                //If it is present, incrementing it's count by 1
 
                wordCount.put(word.toLowerCase(), wordCount.get(word.toLowerCase())+1);
            }
            else
            {
                //If it is not present, put that word into wordCount with 1 as it's value
 
                wordCount.put(word.toLowerCase(), 1);
            }
        }
 
        //Extracting all keys of wordCount
 
        Set<String> wordsInString = wordCount.keySet();
 
        //Iterating through all words in wordCount
 
        for (String word : wordsInString)
        {
            //if word count is greater than 1
 
            if(wordCount.get(word) > 1)
            {
                //Printing that word and it's count
 
                System.out.println(word+" : "+wordCount.get(word));
            }
        }
    }
 
    public static void main(String[] args)
    {
    	DuplicateWordInString("Bread butter and bread");
 
    	DuplicateWordInString("Java is java again java");
 
    	DuplicateWordInString("Super Man Bat Man Spider Man");
    }
    public static void countWords(String[] args)
    {
        System.out.println("Enter the string");
 
        Scanner sc = new Scanner(System.in);
 
        String s=sc.nextLine();
 
        int count = 1;
 
        for (int i = 0; i < s.length()-1; i++)
        {
            if((s.charAt(i) == ' ') && (s.charAt(i+1) != ' '))
            {
                count++;
            }
        }
 
        System.out.println("Number of words in a string = "+count);
    }
    public static void totalNoOfOCurrentOfchar(String[] args)
    {
        String s = "Java is java again java again";
 
        char c = 'a';
 
        int count = s.length() - s.replace("a", "").length();
 
        System.out.println("Number of occurances of 'a' in "+s+" = "+count);
    }
}
