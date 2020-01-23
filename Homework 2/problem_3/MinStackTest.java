//import org.junit.*;
//import static org.junit.Assert.*;

public class MinStackTest {
    
    MinStack stack;
    
    public static boolean testMinStack() {
        // homework
        return false; // placeholder
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
    
    public void RepeatedOccurrenceMinPopped() {
        stack.push(7);
        stack.push(1);
        stack.push(7);
        stack.push(1);
        stack.pop();
        
        int expected=1;
        boolean isWorking = (expected==stack.getMin());
        if(!ifWorking){
            printFailMessage();
        }
        return isWorking();
    }

    @Test
    public void minInMiddleOfTheStack() {
        stack.push(7);
        stack.push(1);
        stack.push(3);
        stack.push(0);
        stack.pop();
        
        int expected=1;
        boolean isWorking = (expected==stack.getMin());
        if(!ifWorking){
            printFailMessage();
        }
        return isWorking();
    }
    
    public boolean minPopped() {
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.pop();
        
        int expected=4;
        boolean isWorking = (expected==stack.getMin());
        if(!ifWorking){
            printFailMessage();
        }
        return isWorking();
    }

    public boolean minInStackNotPopped() {
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        int expected=3;
        boolean isWorking = (expected==stack.getMin());
        if(!ifWorking){
            printFailMessage();
        }
        return isWorking();
    }

    public boolean minLastElementNoPopping() {
        stack.push(9);
        stack.push(8);
        
        int expected=8;
        boolean isWorking = (expected==stack.getMin());
        if(!ifWorking){
            printFailMessage();
        }
        return isWorking();
    }

    public boolean testPush() {
        stack.push(88);
        
        int expected=88;
        boolean isWorking = (expected==stack.peek());
        if(!ifWorking){
            printFailMessage();
        }
        return isWorking();
    }

    public boolean whenMultipleValuesArePushedTopResurnsTheMostRecent() {
        stack.push(77);
        stack.push(99);
        
        int expected = 99;
        boolean isWorking = (expected==stack.peek());
        if(!ifWorking){
            printFailMessage();
        }
        return isWorking();
    }
    
    private static void printFailMessage(String testName, String expected, String actual) {
        System.out.println(testName + " : " + ", expected: " + expected + ", actual: " + actual);
    }

}
