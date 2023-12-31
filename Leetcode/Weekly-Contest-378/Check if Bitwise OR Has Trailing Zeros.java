class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int result = nums[i] | nums[j];
                if (result % 2 == 0) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return false;
    }
}
