public class ValidParentheses {
    public static boolean isValid(String str) {
        Map<Character, Character> parenthesesMapping = new HashMap<>();
        parenthesesMapping.put('(', ')');
        parenthesesMapping.put('{', '}');
        parenthesesMapping.put('[', ']');

        Stack parentheses = new Stack();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(parenthesesMapping.containsKey(c)) {
                parentheses.push((int)c);    
            } else {
                if(parentheses.isEmpty()) {
                    return false;
                }
                char target = parentheses.pop();
                if(!parenthesesMapping.containsKey(target) || parenthesesMapping.get(target) != c) {
                    return false;
                }
            }
        }
        if(!parentheses.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean testIsValid() {
        String[] inputs = {"(}","{}()", ")[]("};
        boolean[] expected = {false, true, false};

        // homework
        return false; // place holder
    }
}
