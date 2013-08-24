package combinations;

import java.util.LinkedList;
import java.util.List;

public class CoinSelection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(computeCoins(new LinkedList<Integer>(), 0));
		
		System.out.println(minC(60));

	}
	
	/*static int done = 15;
	static int[] coins = {1 2 5 10 20 50 100 500 1000};*/
	static int[] coins =  {50,20,1};
	static int done = 60;
	
	
	static int count( int[] S, int m, int n )
	{
	    // If n is 0 then there is 1 solution (do not include any coin)
	    if (n == 0)
	        return 1;
	     
	    // If n is less than 0 then no solution exists
	    if (n < 0)
	        return 0;
	 
	    // If there are no coins and n is greater than 0, then no solution exist
	    if (m <=0 && n >= 1)
	        return 0;
	 
	    // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
	    return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
	}

	
	public static List<Integer> computeCoins(List<Integer> sel,int soFar){
		if(soFar == done) {
			System.out.println(sel);
			return sel;
		}
		else{
			for(int i=0;i<coins.length;i++){
				if(soFar + coins[i] <= done) {
					//there are 2 choices we can make, take it or not
					//and we have to return the minimum of both
					//2) take it
					sel.add(i);
					return computeCoins(sel,soFar+coins[i]);
				}//else dont take it, moveon to the next coin
			}
		}

		return sel;
	}
	
   static int v = 0;

   public static int minC(int amount){
	   int minimum = Integer.MAX_VALUE;
	   for(int i = 0; i < coins.length ; i++){
		   if(amount == coins[i]) {
			   return 1;
		   }
		   else if(amount - coins[i] > 0) {
			   int temp = minC(amount - coins[i]) + 1;
			   if(temp < minimum){
				   minimum = temp;
			   }   
		   }
	   }
	   return minimum;
   }
	public static int min(int amount, Integer w){
		boolean flag = false;
		boolean out = false;
		int i = coins.length - 1;
		int t = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int value = Integer.MIN_VALUE;
		do {
			if(amount - coins[i] > 0) {
				t = min(amount - coins[i],w);
				if(!flag || t < min - 1) {
					value = i;
					min = t+1;
					flag =true;
				}
			}
			else if(amount-coins[i] == 0) {
				value = i;
				min = 1;
				flag = true;
				out = true;
			}
		    i = i-1;
			
		}while(i > 0 && !out);
		w=value;
		v=value;
		return min;
	}
	
	public static void findcoins(int amt){
		int[] c= new int[coins.length];
		for(int i = 0; i<coins.length;i++){
			c[i] = 0;
		}
		Integer myInt=0;
		int j = 0;
		do {
			j = min(amt,myInt);
			c[v] += 1;
			System.out.println(v);
			amt -= coins[v];
		}while(amt !=0);
	}

}
