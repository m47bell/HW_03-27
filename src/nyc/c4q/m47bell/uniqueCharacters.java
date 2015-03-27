package nyc.c4q.m47bell;

import java.util.Scanner;

/* Marbella Vidals
* Access Code 2-1
* Homework # 5
* Write a function uniqueCharacters which accepts as input a string S.
* Given the string S return a string S2 which contains all the distinct characters in S.
* The input string will only contain lowercase characters.
* The ordering of characters in the output string does not matter.
*/
public class uniqueCharacters {

    public static void main(String[] args) {
	// write your code here

     Scanner input = new Scanner(System.in);

     System.out.println("Enter a word (use lowercase letters): ");

     String s = input.nextLine();

     //check if string s contains only lowercase characters

     boolean lowercaseLetter = !s.equals(s.toLowerCase());

        if(lowercaseLetter){

            System.out.println("Enter in lowercase form:");
            s=input.nextLine();
        }

     //Print output
        System.out.println(uniqueCharacters(s));

    }

    public static String uniqueCharacters(String s){
        //Initialize the final string output
        String finalS = "";

        //iterate entire string to check each char
        for(int i=0;i < s.length();i++){
            //if there is no duplicate char, then concatenate new string with out duplicates
            if(!finalS.contains("" + s.charAt(i))){
              finalS += ""+ s.charAt(i);
            }

        }

        return finalS;
    }

}



