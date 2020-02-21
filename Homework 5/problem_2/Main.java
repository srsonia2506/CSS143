import java.util.Stack;

public class Main {

    public static void main(String[] args) {
    }

    static void insert_at_bottom(int x, Stack<Integer> stack){ 
        if(stack.isEmpty()) 
            stack.push(x);   
        else{ 
            int a = stack.peek(); 
            stack.pop(); 
            insert_at_bottom(x, stack); 
            stack.push(a); 
        } 
    } 

    public static void ReverseStack(Stack<Integer> stack) {
        if(stack.size() > 0){ 
            int topElement = stack.peek(); 
            stack.pop(); 
            ReverseStack(stack); 
            insert_at_bottom(topElement, stack); 
        } 
    }
}
