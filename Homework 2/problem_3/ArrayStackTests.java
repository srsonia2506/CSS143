public class ArrayStackTests {
    public static boolean testArrayStackEmpty() {
        ArrayStack stack = new ArrayStack(5);
        String testName = "testArrayStack";
        if (stack.size() != 0) {
            printFailMessage(testName, "size wrong", String.valueOf(0), String.valueOf(stack.size()));
            return false;
        }
        if (stack.pop()) {
            printFailMessage(testName, "pop wrong", String.valueOf(false), String.valueOf(true));
            return false;
        }
        return true;
    }

    public static boolean testArrayStackOfSizeOne() {
        // homework
        return false;   // placeholder
    }

    public static boolean testArrayStackOfSizeTwo() {
        // homework
        return false;   // placeholder
    }

    public static boolean testArrayStackOfSizeThree() {
        // homework
        return false;   // placeholder
    }

    private static void printFailMessage(String testName, String message, String expected, String actual) {
        System.out.println(testName + " : " + message +
                ", expected: " + expected +
                ", actual: " + actual);
    }
}