import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String str) {
        Map<Character, Character> parenthesesMapping = new HashMap<>();
        parenthesesMapping.put('(', ')');
        parenthesesMapping.put('{', '}');
        parenthesesMapping.put('[', ']');

        ArrayStack parentheses = new ArrayStack(str.length());
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(parenthesesMapping.containsKey(c)) {
                parentheses.push(c);    
            } else {
                if(parentheses.size()==0) {
                    return false;
                }
                char target = (char)parentheses.peek().getData();
                parentheses.pop();
                if(!parenthesesMapping.containsKey(target) || parenthesesMapping.get(target) != c) {
                    return false;
                }
            }
        }
        if(parentheses.size()>0) {
            return false;
        }
        return true;
    }

    public static boolean testIsValid() {
        String[] inputs = {"(}","{}()", ")[]("};
        boolean[] expected = {false, true, false};

        boolean anyFailed = false;

        for(int i=0; i<inputs.length; i++){
          if (isValid(inputs[i])!=expected[i]) {
            System.out.printf("Valid Parentheses: case %d failed, expected: %s, actual %s\n", i+1, expected[i], inputs[i]);
            anyFailed = true;
            break;        
          }
        }
        return !anyFailed;
    }
}
