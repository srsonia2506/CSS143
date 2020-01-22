public class MinStack extends ArrayStack {

    public MinStack(int size) {
        super(size);
    }

    // add your comments for your design here
    public StackElement getMin() {
        if (s.isEmpty()) return new StackElement(0, false);
        else return new StackElement(minElement, true);
    }
}