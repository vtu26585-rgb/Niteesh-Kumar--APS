class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;   // use lowercase 'candidate'
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
