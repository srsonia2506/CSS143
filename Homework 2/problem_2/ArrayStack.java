public class ArrayStack implements Stack {

    private int numElements;
    private int size;
    private int[] data;

    private ArrayStack(){}

    public ArrayStack(int size) {
       this.size=size;
       data= new int[size];
    }
	
    public boolean isEmpty() {
	return (numElements <= 0);
    }
	
    public boolean isFull() {
	return (numElements >= size-1);
    }

    @Override
    public boolean pop() {
	if (data.isEmpty()||data.isFull()){
	    return false;
    } else { 
	    //int val=data[size--];
	    numElements--;
            return true; 
        } 
    }

    @Override
    public boolean push(int val) {
        if (data.isFull()){ 
            return false; 
        }else{ 
            a[++numElements] = val; 
            return true; 
        } 
    }

    @Override
    public StackElement peek() {
        if (data.isEmpty() < 0) { 
            return new StackElement(0, false); ; 
        } else { 
            return new StackElement(a[top], true); 
        } 
    }

    @Override
    public int size() {
        return size;
    }
}
