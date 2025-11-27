import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        SolutionOfInsertDeleteGetRandom sol = new SolutionOfInsertDeleteGetRandom();
        list.add("null");
        boolean exit = false;
        while(true){
            System.out.println("1- insert(int value);\n" +
                               "2- removeNum(int value);\n" +
                               "3- getRandomNumFromList();\n" +
                               "4- printList();\n" +
                               "5- exit.");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the value to insert");
                    int value = sc.nextInt();
                    System.out.println(sol.insert(value));
                    break;
                case 2:
                    System.out.println("Enter the value to remove");
                    value = sc.nextInt();
                    System.out.println(sol.remove(value));
                    break;
                case 3:
                    System.out.println(sol.getRandom());
                    break;
                case 4:
                    sol.toString();
                    break;
                case 5:
                    exit = true;
            }
            if(exit){
                break;
            }
        }
    }
}

//крч это решение по скорости полная хуита, поэтому завтра рассмотрю как рабоатть с map и попробую выбить больше

class SolutionOfInsertDeleteGetRandom {
    private ArrayList<Integer> list;

    public SolutionOfInsertDeleteGetRandom() {
        list= new ArrayList<>();
    }

    public boolean insert(int val) {

        for(int i=0; i<list.size()-1; i++) {
            if(list.get(i)==val) {
                return false;

            }
        }
        list.add(val);
        return true;


    }

    public boolean remove(int val) {
        if(list.size()==0) {
            return false;
        }

        for(int i=0; i<list.size(); i++) {
            if(list.get(i)==val) {
                list.remove(i);
                return true;
            }
        }

        return false;
    }

    public int getRandom() {
        if(list.size()==0) {
            return Integer.MAX_VALUE;
        }
        int random = ThreadLocalRandom.current().nextInt(0, list.size());

        return list.get(random);
    }

    //а вот это для удобства
    public String toString() {
        System.out.println(list.toString());
        return null;
    }
}