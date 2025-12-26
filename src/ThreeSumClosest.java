import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
    
                if(Math.abs(sum-target) < Math.abs(result-target)){
                    result = sum;
                }

                if(sum == target){
                    return target;
                }
                else if(sum > target){
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return result;
    }
}


class SolThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {0,0,0};
        System.out.println(threeSumClosest.threeSumClosest(nums,1));
    }
}