class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int[][] freq = new int[26][n+1];
        char pre = s.charAt(0);
        
        int len = 1;
        freq[s.charAt(0)-'a'][1] = 1;
        int ans = -1;
        for (int i = 1; i<n; i++) {
            char cur = s.charAt(i);
            if (cur == pre) {
                len++;
                int count = 1;
                freq[cur-'a'][len] += 1;


            } else {
                freq[cur-'a'][1] += 1;
   
                pre = cur;
                len = 1;
            }
        }
        for (int i = 0; i<26; i++) {
            int preSum = 0;
            for (int j = n; j>=1; j--) {
                preSum += freq[i][j];
                if (preSum >= 3) {
                    ans=  Math.max(ans, j);
                    break;
                }
            }
        }
   
        return ans;
    }
}
