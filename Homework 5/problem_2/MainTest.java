import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void reverseStack() {
        String[] expected = {
                "[]",
                "[0]",
                "[1, 0]",
                "[2, 1, 0]",
                "[3, 2, 2, 0]"
        };
        List<Stack<Integer>> stackList = getStacks();

        for (int i = 0; i < stackList.size(); i++){
            Main.ReverseStack(stackList.get(i));
            assertEquals(expected[i], stackList.get(i).toString());
        }
    }

    private List<Stack<Integer>> getStacks(){
        List<Stack<Integer>> stackList = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stackList.add(stack);

        stack = new Stack<>();
        stack.push(0);
        stackList.add(stack);

        stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stackList.add(stack);

        stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stackList.add(stack);

        stack = new Stack<>();
        stack.push(0);
        stack.push(2);
        stack.push(2);
        stack.push(3);
        stackList.add(stack);

        return stackList;
    }
}
