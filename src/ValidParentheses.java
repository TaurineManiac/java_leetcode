import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()<2){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' ||  s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                Character c = stack.pop();
                if(!((c == '(' &&  s.charAt(i) == ')') ||  (c == '[' &&  s.charAt(i) == ']') ||  (c == '{' &&  s.charAt(i) == '}'))
                ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


class SolOfValidParentheses{
    public static void main(String[] args){
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("([])"));
    }
}