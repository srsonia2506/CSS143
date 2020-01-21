public class MinStack extends ArrayStack {

    public MinStack(int size) {
        super(size);
    }

    // add your comments for your design here
    public StackElement getMin() {
        return new StackElement(super.minElement, true); 
    }
}
