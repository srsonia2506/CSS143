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

    public static boolean testArrayStackOfSizeOne(){
        ArrayStack stack = new ArrayStack(1);
        String testName = “testArrayStackOfSizeOne”;

        boolean pushVal = stack.push(99); 
        if (!pushVal) {
            printFailMessage(testName, “push wrong”, String.valueof(true), String.valueOf(pushVal));
            return false; 
        }

        if (stack.size() != 1) {
             printFailMessage(testName, “size wrong”, String.valueof(1), String.valueOf(stack.size()));
             return false; 
        }

        StackElement data = stack.peek();         
        if (!data.isValid()){
             printFailMessage(testName, “peek wrong”, String.valueof(true), String.valueOf(false));
             return false; 
        }
        
        boolean removeVal = stack.pop();
        if(!removeVal){
            printFailMessage(testName, “pop wrong”, String.valueof(true), String.valueOf(false));
            return false;
        }
        
        if(stack.size() != 0){
            printFailMessage(testName, “size wrong”, String.valueof(0), String.valueOf(stack.size()));
            return false;
        }              
    
        if(stack.peek().isvalid(){
           printFailMessage(testName, “peek wrong”, String.valueof(0), String.valueOf(true));
           return false;
        }
           
        stack.push(99);
        pushVal = stack.push(100);
        if (pushVal) {
            printFailMessage(testName, “push wrong”, String.valueOf(false), String.valueOf(pushVal));
            return false;
        }
        return true;
        
    } 


    public static boolean testArrayStackOfSizeTwo() {
        ArrayStack stack = new ArrayStack(2);
        String testName = “testArrayStackOfSizeTwo”;

        stack.push(99);
        boolean pushVal = stack.push(100);
        if (!pushVal) {
            printFailMessage(testName, “push wrong”, String.valueof(true), String.valueOf(pushVal));
            return false; 
        }

        if (stack.size() != 2) {
             printFailMessage(testName, “size wrong”, String.valueof(2), String.valueOf(stack.size()));
             return false; 
        }

        StackElement data = stack.peek();         
        if (!data.isValid()|| data.getData()!=100){
             printFailMessage(testName, “peek wrong”, String.valueof(true), String.valueOf(false));
             return false; 
        } 
        
        boolean removeVal = stack.pop();
        if(!removeVal){
            printFailMessage(testName, “pop wrong”, String.valueof(true), String.valueOf(false));
            return false;
        }
        
        if(stack.size() != 1){
            printFailMessage(testName, “size wrong”, String.valueof(0), String.valueOf(stack.size()));
            return false;
        }              
    
        if(stack.peek().isvalid()|| data.getData()==100){
           printFailMessage(testName, “peek wrong”, String.valueof(0), String.valueOf(true));
           return false;
        }
           
        stack.push(99);
        pushVal = stack.push(100);
        if (pushVal) {
            printFailMessage(testName, “push wrong”, String.valueOf(false), String.valueOf(pushVal));
            return false;
        }
        return true;
        
    } 

    public static boolean testArrayStackOfSizeThree() {
        ArrayStack stack = new ArrayStack(3);
        String testName = “testArrayStackOfSizeThree”;

        stack.push(99);
        stack.push(100);
        boolean pushVal = stack.push(101);
        if (!pushVal) {
            printFailMessage(testName, “push wrong”, String.valueof(true), String.valueOf(pushVal));
            return false; 
        }

        if (stack.size() != 3) {
             printFailMessage(testName, “size wrong”, String.valueof(3), String.valueOf(stack.size()));
             return false; 
        }

        StackElement data = stack.peek();         
        if (!data.isValid()|| data.getData()!=101){
             printFailMessage(testName, “peek wrong”, String.valueof(true), String.valueOf(false));
             return false; 
        }
        
        boolean removeVal = stack.pop();
        if(!removeVal){
            printFailMessage(testName, “pop wrong”, String.valueof(true), String.valueOf(false));
            return false;
        }
        
        if(stack.size() != 2){
            printFailMessage(testName, “size wrong”, String.valueof(0), String.valueOf(stack.size()));
            return false;
        }              
    
        if(stack.peek().isvalid()||data.getData()==101){
           printFailMessage(testName, “peek wrong”, String.valueof(0), String.valueOf(true));
           return false;
        }
           
        stack.push(99);
        pushVal = stack.push(100);
        if (pushVal) {
            printFailMessage(testName, “push wrong”, String.valueOf(false), String.valueOf(pushVal));
            return false;
        }
        return true;
        
    } 

    private static void printFailMessage(String testName, String message, String expected, String actual) {
        System.out.println(testName + " : " + message +
                ", expected: " + expected +
                ", actual: " + actual);
    }
}
