public class ArrayStack implements Stack {

    private int data[];
    private int size;
	Integer minElement; 
	Stack<Integer> s; 

    private ArrayStack(){
		this(Integer.MAX_VALUE - 8);
		this.top = -1; 
	}

    public ArrayStack(int size) {
       this.size=size;
	   data= new int[size];
	   s = new Stack<Integer>();
    }

    @Override
    public boolean pop() {
        if (s.isEmpty()) return false;
		
		Integer t=data[size--];

        if (t < minElement){ 

            return false; //PLACEHOLDERRRRRRRRR
        } else {
			//remove top element
            return true;
		}
    }

    @Override
    public boolean push(int val) {
        if (size >= Integer.MAX_VALUE - 8){ 
            return false; 
        }
		
		if (s.isEmpty()||val < minElement){ 
            minElement = val; 
        }
		
		s.push(val); 
		return true;
    }

    @Override
    public StackElement peek() {
        if (s.isEmpty())return new StackElement(0, false); 

        if (t < minElement) return new StackElement(minElement, true); 
        else return new StackElement(a[size-1], true); 

    }

    @Override
    public int size() {
        return size;
    }
}


 
