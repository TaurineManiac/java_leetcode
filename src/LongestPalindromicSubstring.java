public class LongestPalindromicSubstring {

    public boolean isCharEquals(String s1, int index1,int index2){
        return s1.charAt(index1)==s1.charAt(index2);
    }

    int start = 0;
    int end = 0;
    int maxLen = 0;
    String maxStr;

    public String iteratePointers(String s,int i,int j) {
        while((j<s.length() && i >= 0) && isCharEquals(s,i,j)){
            j++;
            i--;
        }
        if(maxLen <  j-i-1){
            maxLen=j-i-1;
            maxStr=s.substring(i+1,j);
        }
        return maxStr;
    }

    public String longestPalindrome(String s) {
        start = 0;
        end = 0;

        if(s.length()<2){
            return s;
        }

        for(int i=0;i<s.length();i++){

            iteratePointers(s,i,i);
            iteratePointers(s,i,i+1);

        }


        return maxStr;
    }
}
