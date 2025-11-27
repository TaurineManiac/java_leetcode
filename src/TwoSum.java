//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target-nums[i];
            if(map.containsKey(num) && map.get(num)!=i){
                return new int[]{map.get(num),i};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return null;
    }



}

class Test {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums1 = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum.twoSum(nums1,9)));
    }
}
