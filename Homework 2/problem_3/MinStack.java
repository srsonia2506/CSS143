public class MinStack extends ArrayStack {

    public MinStack(int size) {
        super(size);
    }
    
    @Override
    public boolean pop() {
	if (size<=0){
	    return false;
    } else { 
	    System.arraycopy(data, 0, data, 0, numElements-1);
	    numElements--;
            return true; 
        } 
    }

    @Override
    public boolean push(int val) {
        if (s.isEmpty()||val < minElement){ 
            minElement = val; 
        }
		
	s.push(val); 
	return true;
    }


    // add your comments for your design here
    public StackElement getMin() {
        if (s.isEmpty()) return new StackElement(0, false);
        else return new StackElement(minElement, true);
    }
}
