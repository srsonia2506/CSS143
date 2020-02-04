import java.util.*;

public class MinStack extends ArrayStack{

    private ArrayStack minimums;

    public MinStack(int size) {
        super(size);
        minimums = new ArrayStack(size);
    }
    
    @Override
    public boolean push(int x) {
      StackElement minValue = minimums.peek();
      if (!minValue.isValid() || x <= minValue.getData()) {
        minimums.push(x);
      }
      return super.push(x);
    }
	
    @Override
    public boolean pop() {      
      StackElement minValue = minimums.peek();
      StackElement topValue = super.peek();

      if (topValue.isValid() && topValue.equals(minValue)) {
        minimums.pop();
      }
      return super.pop();        
    }


    // Having a second stack and add minimums to it. That way, when minimum removed, the next top element in min stack is the new min
    public StackElement getMin() {
      return minimums.peek();
    }
}
