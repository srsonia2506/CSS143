//import org.junit.*;
//import static org.junit.Assert.*;

public class MinStackTest {
    
    public static boolean testMinStack() {
        if(!RepeatedOccurrenceMinPopped()){
            return false;
        }
        if(!minInMiddleOfTheStack()){
            return false;
        }
        if(!minPopped()){
            return false;
        }
        if(!minInStackNotPopped()){
            return false;
        }
        if(!minLastElementNoPopping()){
            return false;
        }
        if(!testPush()){
            return false;
        }
        if(!multipleValuesPushed()){
            return false;
        }
        
        return true; 
    }
    
    /*
    @Before
    public void setup() {
        stack = new MinStack();
    }

    @Test
    assertEquals versus assertSame
    }
    */
    
    public static boolean RepeatedOccurrenceMinPopped() {
        MinStack stack= new MinStack(10);
        String testName = "RepeatedOccurrenceMinPopped";
        
        stack.push(7);
        stack.push(1);
        stack.push(7);
        stack.push(1);
        stack.pop();
        
        int expected=1;
        boolean isWorking = (expected==stack.getMin().getData());
        if(!isWorking){
            printFailMessage(testName,expected,stack.getMin());
        }
        return isWorking;
    }

    public static boolean minInMiddleOfTheStack() {
        MinStack stack= new MinStack(10);
        String testName = "minInMiddleOfTheStack";
        
        stack.push(7);
        stack.push(1);
        stack.push(3);
        stack.push(0);
        stack.pop();
        
        int expected=1;
        boolean isWorking = (expected==stack.getMin().getData());
        if(!isWorking){
            printFailMessage(testName,expected,stack.getMin());
        }
        return isWorking;
    }
    
    public static boolean minPopped() {
        MinStack stack= new MinStack(10);
        String testName = "minPopped";
        
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.pop();
        
        int expected=4;
        boolean isWorking = (expected==stack.getMin().getData());
        if(!isWorking){
            printFailMessage(testName,expected,stack.getMin());
        }
        return isWorking;
    }

    public static boolean minInStackNotPopped() {
        MinStack stack= new MinStack(10);
        String testName = "minInStackNotPopped";
        
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        int expected=3;
        boolean isWorking = (expected==stack.getMin().getData());
        if(!isWorking){
            printFailMessage(testName,expected,stack.getMin());
        }
        return isWorking;
    }

    public static boolean minLastElementNoPopping() {
        MinStack stack= new MinStack(10);
        String testName = "minLastElementNoPopping";
        
        stack.push(9);
        stack.push(8);
        
        int expected=8;
        boolean isWorking = (expected==stack.getMin().getData());
        if(!isWorking){
            printFailMessage(testName,expected,stack.getMin());
        }
        return isWorking;
    }

    public static boolean testPush() {
        MinStack stack= new MinStack(10);
        String testName = "testPush";
        
        stack.push(88);
        
        int expected=88;
        boolean isWorking = (expected==stack.peek().getData());
        if(!isWorking){
            printFailMessage(testName,expected,stack.peek());
        }
        return isWorking;
    }

    public static boolean multipleValuesPushed() {
        MinStack stack= new MinStack(10);
        String testName = "multipleValuesPushed";
        
        stack.push(77);
        stack.push(99);
        
        int expected = 99;
        boolean isWorking = (expected==stack.peek().getData());
        if(!isWorking){
            printFailMessage(testName,expected,stack.peek());
        }
        return isWorking;
    }
    
    private static void printFailMessage(String testName, int expected, StackElement actual) {
        System.out.println(testName + " : " + " expected: " + expected + ", actual: " + actual.getData());
    }

}
