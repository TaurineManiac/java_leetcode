//169. Majority Element
//Easy

//Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//
//
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2
//
//
//Constraints:
//
//n == nums.length
//1 <= n <= 5 * 104
//        -109 <= nums[i] <= 109
//
//
//Follow-up: Could you solve the problem in linear time and in O(1) space?


import java.util.Arrays;

public class FindAMajorityElement {
    public static void main(String[] args) {
        int [ ] arr = {7,6,5,4,3,2,1};
        SolutionOfFindAMajorityElement solution = new SolutionOfFindAMajorityElement();
        System.out.println(solution.findMajorityElement(arr));
    }
}

class SolutionOfFindAMajorityElement {
    public int findMajorityElement(int[] nums) {
        int n = nums.length;
        if(n==0) return -111;
        int half = Math.round(n/2+n%2);
        int majorityElement = 110;
        boolean found = false;
        int start = 0;
        int i=0;
        int countOfIdentity =0;
        while (start < n){

            if(nums[start] == nums[i]){
                countOfIdentity++;

            }
            i++;
            if(i==n && countOfIdentity>=half){
                found = true;
                majorityElement = nums[start];
                break;
            }
            if(i == n ){
                i=1;
                start++;
                countOfIdentity = 0;
            }
        }

        if(found ){
            return majorityElement;
        }
        else{
            return -111;
        }

    }
}



//class Solution {
//    public int majorityElement(int[] nums) {
//        int count=1;
//        if(nums.length==1){
//            return nums[0];
//        }
//        for(int i=1;i<nums.length;i++){
//            insertSort(nums,i);
//        }
//        for(int j=0;j<nums.length-1;j++){
//            if(nums[j]==nums[j+1]){
//                count+=1;
//                if(count>nums.length/2){
//                    return nums[j];
//                }
//            }
//            else count=1;
//
//
//        }
//        return -1;
//    }
//    void insertSort(int[]nums,int i){
//        for(int j=i;j>0;j--){
//            if(nums[j]<nums[j-1]){
//                int temp=nums[j-1];
//                nums[j-1]=nums[j];
//                nums[j]=temp;
//            }
//            else break;
//        }
//    }
//}


