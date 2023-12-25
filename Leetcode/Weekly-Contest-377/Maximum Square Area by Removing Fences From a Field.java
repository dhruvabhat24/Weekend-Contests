class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1_000_000_007;
        Arrays.sort(hFences);
        Arrays.sort(vFences);

        int maxHorizontalGap = getMaxGap(m, hFences);
        int maxVerticalGap = getMaxGap(n, vFences);

        if (maxHorizontalGap == -1 || maxVerticalGap == -1) {
            return -1;
        }

        long maxSide = Math.min(maxHorizontalGap, maxVerticalGap);
        return (int) ((maxSide * maxSide) % MOD);
    }

    private int getMaxGap(int size, int[] fences) {
        int maxGap = -1;
        int fenceCount = fences.length;

        if (fenceCount == 0) {
            return size - 1;
        }

        maxGap = Math.max(maxGap, fences[0] - 1);
        maxGap = Math.max(maxGap, size - fences[fenceCount - 1]);

        for (int i = 1; i < fenceCount; i++) {
            maxGap = Math.max(maxGap, fences[i] - fences[i - 1] - 1);
        }

        return maxGap;
    }
}
