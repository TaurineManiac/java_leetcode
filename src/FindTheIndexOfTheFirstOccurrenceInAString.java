public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        for(int i=0, j=needle.length(); j<=haystack.length(); i++, j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}

class MainOfFindTheFirstOccurrenceInAString{
    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString obj = new FindTheIndexOfTheFirstOccurrenceInAString();
        String haystack = "sazbutsaz";
        String needle = "sad";
        System.out.println(haystack +  " " + needle);
        System.out.println(obj.strStr(haystack,needle));
    }
}
