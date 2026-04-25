public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int start = s.length()-1;
        int length=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                if(start!=i){
                    break;
                }
                start--;
            }
            else{
                length=start-i;
            }
        }
        return length+1;
    }
}

class MainOfLengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("Hello world"));
    }
}
