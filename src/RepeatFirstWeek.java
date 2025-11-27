import java.util.Arrays;

public class RepeatFirstWeek {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,4,5,0,0,0};
        int nums2[] = {3,4,9};
        RepeatMergeSortedArray arr = new RepeatMergeSortedArray();
        arr.merge(nums1, 5, nums2, 3);
        //=========================================================
        int nums3[] = {1,1,1,2,3,4,5,6,7,8,9};
        RepeatRemoveElement remover = new RepeatRemoveElement();
        remover.removeElement(nums3, 1);
        //=========================================================
        int nums4[] = {1,1,2};
        RepeatRemoveDuplicatesFromSortedArray arr2 = new RepeatRemoveDuplicatesFromSortedArray();
        arr2.removeDuplicates(nums4);
        //=========================================================
        int nums5[] = {1,2,2,3,4,5,5,5,6,7,8,8,8,8,9};
        RepeatRemoveElementsAfterTwiceTimeFromSortedArray arr3 = new RepeatRemoveElementsAfterTwiceTimeFromSortedArray();
        arr3.removeDuplicates(nums5);

    }
}

class RepeatMergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return;
        }
        int bigIndex = m-1, smallIndex = n-1;
        int theBiggestIndex = m+n-1;
        while(bigIndex >= 0 && smallIndex >= 0) {
            if(nums1[bigIndex] > nums2[smallIndex]) {
                nums1[theBiggestIndex] = nums1[bigIndex];
                bigIndex--;
                theBiggestIndex--;
            }
            else if(nums1[bigIndex] <= nums2[smallIndex]) {
                nums1[theBiggestIndex] = nums2[smallIndex];
                smallIndex--;
                theBiggestIndex--;
            }
        }
        while(bigIndex >= 0) {
            nums1[theBiggestIndex] = nums1[bigIndex];
            bigIndex--;
            theBiggestIndex--;
        }
        while(smallIndex >= 0) {
            nums1[theBiggestIndex] = nums2[smallIndex];
            smallIndex--;
            theBiggestIndex--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}

class RepeatRemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int k=0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
}

class RepeatRemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int k=1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            else{
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));

        return k;
    }
}

class RepeatRemoveElementsAfterTwiceTimeFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int k=1;
        int counter = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                counter++;
                if(counter < 2){
                    nums[k] = nums[i];
                    k++;
                    continue;
                }
            }
            else if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
                counter = 0;
            }
        }
        System.out.println(Arrays.toString(nums));

        return k;
    }
}