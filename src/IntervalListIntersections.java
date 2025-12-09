import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < A.length && j < B.length) {
            start = Math.max(B[j][0], A[i][0]);
            end = Math.min(A[j][1], B[i][1]);

            if(start <= end){
                ans.add(new int[]{start, end});
            }
            if(end >=A[i][1]){
                i++;
            }
            else if(end >=B[j][1]){
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
