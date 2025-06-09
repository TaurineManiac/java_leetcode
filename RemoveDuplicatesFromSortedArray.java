//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//
//        Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//
//        Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//        Return k.
//        Custom Judge:
//
//        The judge will test your solution with the following code:
//
//        int[] nums = [...]; // Input array
//        int[] expectedNums = [...]; // The expected answer with correct length
//
//        int k = removeDuplicates(nums); // Calls your implementation
//
//        assert k == expectedNums.length;
//        for (int i = 0; i < k; i++) {
//        assert nums[i] == expectedNums[i];
//        }
//        If all assertions pass, then your solution will be accepted.
//
//
//
//        Example 1:
//
//        Input: nums = [1,1,2]
//        Output: 2, nums = [1,2,_]
//        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//        It does not matter what you leave beyond the returned k (hence they are underscores).
//        Example 2:
//
//        Input: nums = [0,0,1,1,1,2,2,3,3,4]
//        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
//        Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
//        It does not matter what you leave beyond the returned k (hence they are underscores).
//
//
//        Constraints:
//
//        1 <= nums.length <= 3 * 104
//        -100 <= nums[i] <= 100
//        nums is sorted in non-decreasing order.

import java.util.Arrays;
import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        SolutionOfRemoveDuplicatesFromSortedArray sol = new SolutionOfRemoveDuplicatesFromSortedArray();
        System.out.println(sol.removeDuplicates(arr));
    }
}

class SolutionOfRemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        boolean hasSimilarNum = false;
        int k = 0;
        boolean firstTime = true;
        ArrayList<Integer> list = new ArrayList<>();
        boolean hasSimilar = false;

        for(int i = 0; i < nums.length; i++) {

            for(int j =0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    hasSimilar = true;

                    for(int z = 0;z< list.size();z++){
                        if(nums[i]== list.get(z)) {
                            firstTime = false;
                        }
                    }

                    if(firstTime) {
                       list.add(nums[i]);
                    }

                }

            }

            if(i==nums.length-1) {
                for(int z = 0;z< list.size();z++){
                    if(nums[i]==nums[z]) {
                        hasSimilar = true;
                    }
                }
            }

            if(!hasSimilar) {
                list.add(nums[i]);
            }
            System.out.println(Arrays.toString(list.toArray()));
            hasSimilar = false;
            firstTime = true;

        }

        for(int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        k = list.size();

        System.out.println(Arrays.toString(nums));
        return k;
    }
}
