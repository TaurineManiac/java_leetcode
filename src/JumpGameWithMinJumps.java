//You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
//
//        Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
//
//        0 <= j <= nums[i] and
//        i + j < n
//        Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
//
//
//
//        Example 1:
//
//        Input: nums = [2,3,1,1,4]
//        Output: 2
//        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
//        Example 2:
//
//        Input: nums = [2,3,0,1,4]
//        Output: 2
//
//
//        Constraints:
//
//        1 <= nums.length <= 104
//        0 <= nums[i] <= 1000
//        It's guaranteed that you can reach nums[n - 1].

import java.util.Arrays;

public class JumpGameWithMinJumps {
    public static void main(String[] args) {
        int [] arr = {2,3,1,1,4};
        SolutionOfJumpGameWithMinJumps solution = new SolutionOfJumpGameWithMinJumps();
        System.out.println(solution.jump(arr));
    }
}

//class SolutionOfJumpGameWithMinJumps {
//
//    private int min = Integer.MAX_VALUE;
//
//    public int jump(int[] nums) {
//        if (nums.length == 1) {
//            return 0;
//        }
//        check(nums, 0, 0);
//        return min;
//    }
//
//    private void check(int[] nums, int pos, int count) {
//        int jump = nums[pos];
//        count++;
//        if (pos + jump >= nums.length - 1) {
//            min = Math.min(min, count);
//            return;
//        }
//        int localMax = 0;
//        int newPos = 0;
//        for (int i = pos + 1; i < pos + jump + 1; i++) {
//            if (i + nums[i] > localMax) {
//                localMax = i + nums[i];
//                newPos = i;
//            }
//        }
//        check(nums, newPos, count);
//    }
//}

//снизу моё решение, сверху тут буду разибраться с решением за 0 мс
//крч мои выводы переменаая локального максимума в его коде не нужна,как и математический минимум,скорее всего являются
// рудиентами предыдущих программ, правда почему этот код рабоает быстрее я не вдупляю конечно,посижу поработаю с нейронкой
//UPTD1: крч она ваще сказалоа что мой код быстрее лол


class SolutionOfJumpGameWithMinJumps {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}
        if(nums.length == 1) {return 0;}
        int maxLenght = nums[0];
        int max=-1;
        int maxIndex=0;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(maxLenght >= nums.length-1){
                System.out.println("grate");
                return count;
            }
            if(nums[i]+i >= maxLenght){
                if(nums[i]+i >= max){
                    max = nums[i]+i;
                    maxIndex = i;
                }
            }
            if(i==maxLenght){

                maxLenght = max;
                i = maxIndex;
                count++;
            }
            if(i>maxLenght){
                System.out.println("looser");
                return 0;
            }
        }
        System.out.println("exit");
        return 0;
    }
}
