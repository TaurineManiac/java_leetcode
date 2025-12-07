import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int oldPoint=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                oldPoint=Math.max(oldPoint,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max =  Math.max(max,i-oldPoint+1);
        }
        return max;
    }
}
