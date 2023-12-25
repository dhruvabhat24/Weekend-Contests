//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int x1;
            x1 = Integer.parseInt(br.readLine());
            
            
            int x2;
            x2 = Integer.parseInt(br.readLine());
            
            
            int x3;
            x3 = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.minDist(x1, x2, x3);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minDist(int x1, int x2, int x3) {
        // code here
        int[] points = {x1,x2,x3};
        Arrays.sort(points);
        int median = points[1];
        int totalDistance=0;
        for(int point:points){
            totalDistance +=Math.abs(point - median);
        }
        return totalDistance;
    }
}
        
