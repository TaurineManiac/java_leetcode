import java.util.Arrays;

public class Candy {
    int sum=0;
    int[] candy;

    public int candy(int[] ratings) {
        if(ratings.length<=1){
            return 1;
        }
        candy=new int[ratings.length];
        for(int i = 0; i < ratings.length; i++){
            candy[i]=1;
        }
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        for(int i = ratings.length-1; i >= 1; i--){
            if(ratings[i-1]>ratings[i]){
                candy[i-1]=Math.max(candy[i-1],candy[i]+1);
            }
            sum+=candy[i-1];
        }
        return sum+candy[candy.length-1];
    }
}

class MainOfCandy {
    public static void main(String[] args) {
        Candy candy=new Candy();
        int[] ratings={1,2,2};
        System.out.println(Arrays.toString(ratings));
        System.out.println(candy.candy(ratings));
    }
}
