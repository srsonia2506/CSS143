public class Main {
    public static void main(String[] args) {
        System.out.println("testArrayStackEmptyQueue " + (ArrayStackTests.testArrayStackEmpty() ? "PASSED" : "FAILED"));
        System.out.println("testArrayStackOfSizeOne " + (ArrayStackTests.testArrayStackOfSizeOne() ? "PASSED" : "FAILED"));
        System.out.println("testArrayStackOfSizeTwo " + (ArrayStackTests.testArrayStackOfSizeTwo() ? "PASSED" : "FAILED"));
        System.out.println("testArrayStackOfSizeThree " + (ArrayStackTests.testArrayStackOfSizeThree() ? "PASSED" : "FAILED"));
        System.out.println("ValidParentheses.testIsValid " + (ValidParentheses.testIsValid() ? "PASSED" : "FAILED"));
    }
}
