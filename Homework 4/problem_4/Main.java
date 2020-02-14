import java.util.*;

public class Main {

    public static void main(String[] args) {
        testPossibleParentheses();
    }

    private static void possibleParentheses(List<String> outputs, int n) {
        if (n == 0)return;
        parentheses(outputs, "", n);
    }

    private static void parentheses(List<String> res, String str, int n) {
        int numOpen = str.replace("}", "").length();
        int numClose = str.length() - numOpen;

        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }

        if (numOpen < n)
            parentheses(res, str + '{', n);

        if(numClose < numOpen)
            parentheses(res, str + '}', n);
    }

    private static void testPossibleParentheses() {
        boolean passed = true;

        String[][] expected = {
                {},
                {"{}"},
                {"{}{}", "{{}}"},
                {"{}{}{}", "{}{{}}", "{{}}{}", "{{}{}}", "{{{}}}"}
        };

        for (int i = 0; i < expected.length; i++) {
            List<String> actual = new ArrayList<>();
            possibleParentheses(actual, i);
            if (expected[i].length != actual.size()) {
                System.out.printf("testCase %d: expected size was %d but got %d\n",
                        i, expected[i].length, actual.size());
                passed = false;
            } 

            for (int j = 0; j < actual.size(); j++) {
              Arrays.sort(expected[i]);
              Collections.sort(actual);
              if (!actual.get(j).equals(expected[i][j])) {
                System.out.printf("testCase %d:\nExpected %s\nbut got  %s\n",i, Arrays.toString(expected[i]), actual);
                passed = false;
                break;
              }
            }
        }

        System.out.printf("testPossibleParentheses %s\n", passed ? "PASSED" : "FAILED");
    }
}
