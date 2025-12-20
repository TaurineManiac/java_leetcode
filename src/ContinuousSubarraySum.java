import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %=k;
            if(map.containsKey(sum)){
               if(i - map.get(sum) > 1) {
                   return true;
               }
            }
            else{
                map.put(sum, i);
            }
        }
        return false;
    }
}


class SolOfContinuousSubarraySum {
    public static void main(String[] args) {
        ContinuousSubarraySum cs = new ContinuousSubarraySum();
        int[] nums = {0};
        System.out.println(cs.checkSubarraySum(nums, 1));
    }
}
