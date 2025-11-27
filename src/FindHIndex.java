import java.util.Arrays;

public class FindHIndex {
    public static void main(String[] args) {
        int[] arr = {3,0,6,1,5};
        SolutionOfFindHIndex sol = new SolutionOfFindHIndex();
        System.out.println(sol.hIndex(arr));
    }
}


class SolutionOfFindHIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int counter = 0;
        int iterator = 1;
        for (int i = citations.length-1; i>=0; i--) {
            if(citations[i] >= iterator) {
                counter++;
            }
            iterator++;
        }
        return counter;
    }
}

//вот тут крч моё решение,но оно супер медленное,сейчас рассмортим решение которое было на топ 3 по скорости,
//потому что на топ ё11 я уже прям совсем не понял

//class SolutionOfFindHIndex {
//    public int hIndex(int[] citations) {
//        int min = Integer.MAX_VALUE;
//        boolean firstTime = true;
//        for (int i = 0; i < citations.length; i++) {
//            BubbleSort(citations,i);
//        }
//
//        System.out.println(Arrays.toString(citations));
//        for (int i = citations.length - 1; i >= 0; i--) {
//
//            if(citations[i] > min || firstTime) {
//                firstTime = false;
//                if(citations[i] > citations.length-i) {
//                    min = citations.length-i;
//                }
//                else if(citations[i] <= citations.length-i) {
//                    min = citations[i];
//                }
//
//            }
//
//        }
//
//        return min;
//    }
//
//    public void BubbleSort(int[] citations,int i) {
//            for (int j = i+1; j < citations.length ; j++) {
//                if (citations[i] > citations[j]) {
//                    int temp = citations[i];
//                    citations[i] = citations[j];
//                    citations[j] = temp;
//                }
//            }
//
//
//    }
//}
