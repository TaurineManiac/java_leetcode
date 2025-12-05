import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.max;


public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int oldPoint=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                max = max(max,i-oldPoint+1);
            }
            else{
                int tempNum = map.get(s.charAt(i));
                for(int j=oldPoint;j<=tempNum;j++){
                    map.remove(s.charAt(j));
                    oldPoint++;
                }

                map.put(s.charAt(i),i);
                max = max(max,i-oldPoint+1);
            }
        }
        return max;
    }
}
