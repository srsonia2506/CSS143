import java.util.*;

public class MinStack extends ArrayStack{

    private Deque<Integer> stack = new LinkedList<Integer>();
    private Deque<Integer> minimums = new LinkedList<Integer>();

    public MinStack(int size) {
        super(size);
    }
    
    @Override
    public boolean push(int x) {
        if (stack.size==super.data.length){ 
            return false; 
        } else if (x <= getMin()||stack.size==0) {
            minimums.push(x);
        }
        stack.push(x);
		return true;
    }
	
	@Override
    public boolean pop() {
	if (stack.size()==0){
		return false;
	} 
        int removed = stack.peek();
		stack.pop();
        if (removed == getMin()) {
            minimums.pop();
        }
		return true;
    }


    // Having a second stack and adds minimums to it. That way, even if minimum removed, the next top element in stack is the min
    public StackElement getMin() {
        if (stack.size()==0) return new StackElement(0, false);
        else return new StackElement(minimums.peek(), true);
    }
}
