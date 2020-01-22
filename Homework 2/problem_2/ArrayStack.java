import java.lang.*;

public class ArrayStack implements Stack {

    private int numElements=0;
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
	if (data.isEmpty()){
	    return false;
    } else { 
	    System.arraycopy(data, 0, data, 0, numElements-1);
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
