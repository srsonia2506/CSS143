public class ArrayStack implements Stack {

    private int size;
	private int[] data;
    int top;  

    private ArrayStack(){
		this(Integer.MAX_VALUE - 8);
		this.top = -1; 
	}

    public ArrayStack(int size) {
       this.size=size;
	   data= new int[size];
    }

    @Override
    public boolean pop() {
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } else { 
            int x = a[top--]; 
            return x; 
        } 
    }

    @Override
    public boolean push(int val) {
        if (top >= (MAX - 1)){ 
            return false; 
        }else{ 
            a[++top] = val; 
            return true; 
        } 
    }

    @Override
    public StackElement peek() {
        if (top < 0) { 
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
