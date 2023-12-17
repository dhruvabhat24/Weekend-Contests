//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            long res = obj.totalWays(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long totalWays(int N) {
        // code here
        return factorial(N);
    }
    private static long factorial(int n){
        if(n <=1){
            return 1;
        }else 
        { 
            return n* factorial(n-1);
        }
    }
}
