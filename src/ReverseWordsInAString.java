import java.util.Stack;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        int end  = s.length() - 1;
        char[] chars = s.toCharArray();
        char[] result = new char[end+1];
        int index = 0;
        while (end>=0) {
            while(end>=0 && chars[end]==' ') end--;
            if(end<0) {break;}

            int start = end;
            while(start>=0 && chars[start]!=' '){
               start--;
            }

            if(index!=0){
                result[index++] = ' ';
            }

            for(int i=start+1;i<=end;i++){
                result[index++] = chars[i];
            }

            end=start-1;
        }
        return new String(result,0,index);
    }
}

class MainOfReverseWords{
    public static void main(String[] args) {
        ReverseWordsInAString rw = new ReverseWordsInAString();
        rw.reverseWords("the");
    }
}
