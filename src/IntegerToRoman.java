import java.util.Scanner;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        final String[] symbols= {"M", "CM", "D", "CD","C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        if(num==0){
            return "";
        }
        for(int i=0;i<nums.length;i++){

            while(num>=nums[i]){
                num-=nums[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}


class solOfRomanToInteger {
    public static void main(String[] args) {
        IntegerToRoman it = new IntegerToRoman();
        System.out.println(it.intToRoman(1994));
    }
}