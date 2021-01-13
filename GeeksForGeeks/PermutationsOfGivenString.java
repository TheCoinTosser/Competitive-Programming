// https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in); 
		int T = in.nextInt();
		in.nextLine();
		for(int t=1; t<=T; t++){
		    final String S = in.nextLine();
		    final ArrayList<String> allPermutations = permutations(S);
		    Collections.sort(allPermutations);
		    for(String sortedPermutation : allPermutations){
		        System.out.print(sortedPermutation + " ");
		    }
		    System.out.println();
		}
	}
	
	private static ArrayList<String> permutations(String s){
	    if(s.isEmpty()) return new ArrayList<String>();
	    if(s.length() == 1) {
	        final ArrayList<String> unitArray = new ArrayList<String>();
	        unitArray.add(s);
	        return unitArray;
	    }
	    
	    // size at least 2
	    
	    final ArrayList<String> permList = new ArrayList<String>();
	    for(int i=0; i<s.length(); i++){
	        final ArrayList<String> subPermutations = permutations(s.substring(0, i) + s.substring(i+1, s.length()));
	        for(String subPermutation: subPermutations) {
	            permList.add(String.valueOf(s.charAt(i)) + subPermutation);
	        }
	    }
	    
	    return permList;
	}
}