import java.util.ArrayList;

public class MergeTwoSortedArrayListsExpertSoft {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int sizeOfFirstArrayList = a.size();
        int sizeOfSecondArrayList = b.size();
        for (int z = 0; z < sizeOfSecondArrayList; z++) {
            a.add(0);
        }
        int i=sizeOfFirstArrayList-1;
        int j=sizeOfSecondArrayList-1;
        int newIndexOfFirstArrayList = sizeOfFirstArrayList + sizeOfSecondArrayList-1;
        while(i>=0 && j>=0){
            if(a.get(i)<=b.get(j)){
                a.set(newIndexOfFirstArrayList--, b.get(j--));
            }
            else{
                a.set(newIndexOfFirstArrayList--, a.get(i--));
            }

        }
        while(j>=0){
            a.set(newIndexOfFirstArrayList--, b.get(j--));
        }

    }
}
