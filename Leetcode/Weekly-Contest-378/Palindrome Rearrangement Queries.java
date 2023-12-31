class Solution {
    int n;
    int opp(int i) {
        return n - 1 - i;
    } 
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        int[] fq = new int[26];
        int m = queries.length;
        boolean[] ret = new boolean[m];    
        n = s.length();
        for (int i = 0; i < n / 2; i++) {
            fq[s.charAt(i) - 'a']++;
        }
        for (int i = n / 2; i < n; i++) {
            fq[s.charAt(i) - 'a']--;
        }
        for (int em : fq) {
            if (em != 0) {
                return ret;
            }
        }
        int problemPoint = -1;
        int lastProblem = -1;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(opp(i))) {
                if (problemPoint == -1) {
                    problemPoint = i;
                }
                lastProblem = i;
            }
        }
        if (problemPoint == -1) {
            Arrays.fill(ret, true);
            return ret;
        }
        int[] dpFirst = new int[n / 2 + 1];
        int[] dpSecond = new int[n + 1];
        Arrays.fill(dpFirst, -1);
        Arrays.fill(dpSecond, -1);
        int rptr = opp(problemPoint);
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = problemPoint; i < n / 2; i++) {
            mp.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            while (mp.containsKey(s.charAt(rptr))) {
                mp.computeIfPresent(s.charAt(rptr), (k, v) -> v == 1 ? null : v - 1);
                
                rptr--;
            }      
            dpFirst[i] = rptr;
        }
        int lptr = problemPoint;
        mp.clear();
        for (int i = opp(problemPoint); i >= n / 2; i--) {
            mp.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            
            while (mp.containsKey(s.charAt(lptr))) {
                mp.computeIfPresent(s.charAt(lptr), (k, v) -> v == 1 ? null : v - 1);
                lptr++;
            }            
            dpSecond[i] = lptr;
        }     
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int c = queries[i][2];
            int d = queries[i][3];
            if ((a > problemPoint || b < problemPoint) && (d < opp(problemPoint) || c > opp(problemPoint))
               || (a > lastProblem || b < lastProblem) && (d < opp(lastProblem) || c > opp(lastProblem))) {
                continue;
            }
            if (a <= problemPoint && b >= lastProblem || c <= opp(lastProblem) && d >= opp(problemPoint)) {
                ret[i] = true;
                continue;
            }
            if (a <= problemPoint && b >= problemPoint) {
                if (d >= dpFirst[b] && c <= opp(lastProblem)) {
                    ret[i] = true;
                }
            }
            if (d >= opp(problemPoint) && c <= opp(problemPoint)) {
                if (a <= dpSecond[c] && b >= lastProblem) {
                    ret[i] = true;
                }
            }
        }        
        return ret;
    }
}
