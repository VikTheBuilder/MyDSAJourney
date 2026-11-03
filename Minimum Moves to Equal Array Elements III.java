//brute--
class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for(int i =0; i<nums.length ;i++){
            result += nums[nums.length-1] - nums[i];
        }
        return result;
    }
}
//faster--
class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for (int x : nums){
            if (x > max){
                max = x;
            }
        }
        int result = 0;
        for (int x : nums){
            result += max - x;
        }
        return result;
    }
}
