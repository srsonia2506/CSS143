//import java.lang.*;

public class ArrayStack implements Stack {

    //private int numElements=0;
    private int size;
    private int[] data;

    private ArrayStack(){}

    public ArrayStack(int size) {
       this.size=0;
       data= new int[size];
    }
	
  /*
    public boolean isEmpty() {
	return (size <= 0);
    }
	
    public boolean isFull() {
	return (size >= data.length-1);
    }
  */

    @Override
    public boolean pop() {
	if (size == 0){
	    return false;
    } else { 
	    data[size -1]=0;
	    size--;
            return true; 
        } 
    }

    @Override
    public boolean push(int val) {
        if (size==data.length){ 
            return false; 
        }else{ 
            data[size] = val; 
	          size++;	
            return true; 
        } 
    }

    @Override
    public StackElement peek() {
        if (size <= 0) { 
            return new StackElement(0, false);
        } else { 
            return new StackElement(data[size-1], true); 
        } 
    }

    @Override
    public int size() {
        return size;
    }
}
