package edu.northeastern.info6205;

public class Solution {

    //Time O(nm) ; Space O(nm)
	public static String getResult(char[][] body, int maxTime){
		int n = body.length;
        int m = body[0].length;
        if(n ==0 || m==0){
        	return "can infect";
        }
        int[][] dp = new int[n][m];
        if(body[0][0]==0){
            dp[0][0]='X';
        }
        for (int i = 0; i < n; i++) {
            if (body[i][0] != 'X') {
                dp[i][0] = 'X';
            } else {
                break; 
            }
        }
        
        for (int j = 0; j < m; j++) {
            if (body[0][j] != 'X') {
                dp[0][j] = 'X'; 
            } else {
                break;
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (body[i][j] != 'X') {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                   continue;
                }
            }
        }
        if(dp[n-1][m-1]>=maxTime) {
        	return "can infect";
        }else {
        	
        }
        return "can not infect";
	}
	
	
	//Time: O(n), Space: O(n)
	public static int fib(int n) {
		int a = 0;
		int b = 1;
		for (int i = 0; i < n - 1; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(fib(5));
		System.out.println(fib(10));
		System.out.println(fib(13));
		System.out.println(fib(21));
		
		
		
	}

}
