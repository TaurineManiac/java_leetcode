import java.util.*;

public class TrappingRainWater{
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxLeft=0;
        int maxRight=height.length-1;
        int sum=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>height[maxLeft]){
                    maxLeft=left;
                }
                else{
                    sum+=height[maxLeft]-height[left];
                }
                left++;
            }
            else{
                if(height[right]>height[maxRight]){
                    maxRight=right;
                }
                else{
                    sum+=height[maxRight]-height[right];
                }
                right--;
            }
        }
        return sum;
    }
//        int sum=0;
//        int temporarySum=0;
//        int start=0;
//        for(int i = 1; i < height.length; i++){
//            if(height[i]<=height[start]){
//                temporarySum+=height[start]-height[i];
//            }
//            else{
//                sum+=temporarySum;
//                temporarySum=0;
//                start=i;
//            }
//        }
//        start=height.length-1;
//        temporarySum=0;
//        for(int i = height.length-2; i >= 0; i--){
//            if(height[i]<height[start]){
//                temporarySum+=height[start]-height[i];
//            }
//            else{
//                sum+=temporarySum;
//                temporarySum=0;
//                start=i;
//            }
//        }
//        return sum;
//    }
}

class MainOfTrappingRainWater{
    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(arr));
        System.out.println(trappingRainWater.trap(arr));
    }
}
