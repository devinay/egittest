package combinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadAndPrintCombinations {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// prompt the user to enter their name
		System.out.println(maximizeV(10,0));
		/*
		System.out.print("Enter your name: ");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(fib(Integer.parseInt(bufferRead.readLine())));
		*/
		// open up standard input
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your name!");
			ioe.printStackTrace();
			System.exit(1);
		}
		String[] toks = input.split(" ");
		*/
	}
	
	public static void doPerms(String str) {
		
	}
	
	public static void permute(String soFar, String rest) {
		if(rest.isEmpty())
			System.out.println(soFar);
		else {
			for(int i=0 ; i< rest.length() ; i++){
				char next = rest.charAt(i);
				if(goAhead(rest.substring(i+1),next))
					permute(soFar + next, rest.substring(0, i) + rest.substring(i+1));
			}
		}
	}
	
	public static boolean goAhead(String soFar, char next)
	{
		boolean goAhead = true;
		for(int i=0;i<soFar.length();i++) {
			if(soFar.charAt(i) == next)
				return false;
		}
		return goAhead;
	}
	
	public static void combine(String soFar, String rest) {
		if(rest.isEmpty())
			System.out.println(soFar);
		else {
			char next = rest.charAt(0);
			combine(soFar + next, rest.substring(1));
			combine(soFar, rest.substring(1));
		}
	}
	
	public static int fib(int n) {
		if(n==0)
			return 0;
		else if (n==1)
			return 1;
		return fib(n-1) + fib(n-2);
	}
	
	//price of the object
	public static int[] vals = {7,2,1,6,12};
	//weight of the object
	public static int[] wts = {3,1,2,4,6};
	//the total capacity of the knapsack
	public static int capacity = 10;
	
	public static int maximizeV(int c, int idx){
		printarr(idx);
		if(idx >= vals.length) return 0;
		else {
			//is remaining capacity is less than the weight of the current object under consideration
			//recur using the next object
			if(c < wts[idx]) 
				return maximizeV(c,idx+1);
			//the more interesting case, we CAN consider the current object, in which case we need to return
			//the MINIMUM of the choices of taking the object or not
			//Lecture 18 time: 23:23 Dynamic programming nptelhrd
			else {
				//return Math.max(maximizeV(c,idx+1,depth++), vals[idx] + maximizeV(c - wts[idx], idx+1,depth++));
				int l = maximizeV(c,idx+1);
				int r = vals[idx] + maximizeV(c - wts[idx], idx+1);
				if (r > l)
					System.out.println("cap:"+ (c - wts[idx]) + " idx:" + idx + " wt:" + wts[idx] + " value:" + vals[idx]);
				return Math.max(maximizeV(c,idx+1), vals[idx] + maximizeV(c - wts[idx], idx+1));
			}		
		}
	}
	
	public static void printarr(int idx)
	{
		/*
		System.out.print("At depth " + depth + " :");
		for(int i = 0; i<=idx && i < vals.length; i++){
			System.out.print(wts[i] +" ");
		}
		System.out.println();
		*/
	}

}
