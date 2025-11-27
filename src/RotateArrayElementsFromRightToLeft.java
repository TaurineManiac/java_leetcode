//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//Example 2:
//
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//
//
//Constraints:
//
//        1 <= nums.length <= 105
//        -231 <= nums[i] <= 231 - 1
//        0 <= k <= 105
//
//
//Follow up:
//
//Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
//Could you do it in-place with O(1) extra space?


import java.util.Arrays;

public class RotateArrayElementsFromRightToLeft {
    public static void main(String[] args) {
        int[] arr = { 2147483647,-2147483648,33,219,0};
        SolutionOfRotateArrayElementsFromRightToLeft sol = new SolutionOfRotateArrayElementsFromRightToLeft();
        sol.rotate(arr, 4);
    }
}

class SolutionOfRotateArrayElementsFromRightToLeft {
    public void rotate(int[] nums, int k) {
        if(k>nums.length){
            k%=nums.length;
        }
        System.out.println(Arrays.toString(nums));
        reverse(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        reverse(nums,0,k-1);
        System.out.println(Arrays.toString(nums));
        reverse(nums,k,nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums, int start, int end) {

        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}

//Это слишком медленный способ

//class SolutionOfRotateArrayElementsFromRightToLeft {
//    public void rotate(int[] nums, int k) {
//        while (k > nums.length) {
//            k -= nums.length;
//        }
//        if(k==0){
//            return;
//        }
//        if(nums.length==0){
//            return;
//        }
//        if(nums.length>Math.pow(10, 5) || nums.length<0){
//            return;
//        }
//        if(k<0 || k>Math.pow(10, 5)){
//            return;
//        }
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i]<Math.pow(-2,31) || nums[i]>Math.pow(2,31)-1){
//                return;
//            }
//        }
//
//        int temp_low = 0;
//        int temp_high = 0;
//
//
//
//        for(int i=0; i< k;i++){
//            if(nums.length==2){
//                temp_high = nums[0];
//                nums[0]=nums[nums.length-1];
//                nums[nums.length-1]=temp_high;
//            }
//            else{
//                for(int j= 1; j< nums.length;j++){
//
//
//                    if(j==1){
//                        temp_low = nums[j];
//                        nums[1] = nums[0];
//
//                        continue;
//                    }
//                    if(j==nums.length-1){
//                        nums[0]= nums[j];
//
//                    }
//                    temp_high = nums[j];
//                    nums[j] = temp_low;
//                    temp_low = temp_high;
//                }
//            }
//
//        }
//        System.out.println(Arrays.toString(nums));
//    }
//}
