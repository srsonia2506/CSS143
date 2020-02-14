public class LinkedListTests extends Tests {

    public static void testAll() {
        testReverseRecursive();
        testEmptyList();
        testListWithMultipleElements();
        testToString();
    }

    public static void testReverseRecursive() {
        int[][] inputs = {
                            {},
                            {1},
                            {1, 2},
                            {3, 3},
                            {1, 4, 2},
                            {3, 4, 5, 6, 7},
                          };

        String[] expected = {
                              "",
                              "1 -> end ",
                              "2 -> 1 -> end ",
                              "3 -> 3 -> end ",
                              "2 -> 4 -> 1 -> end ",
                              "7 -> 6 -> 5 -> 4 -> 3 -> end ",
                            };

        boolean passed = true;

        for (int i = 0; i < inputs.length; i++) {
            SingleLinkedList list = arraytoLinkedList(inputs[i]);
            list.reverseRecursive();
            String actual = list.toString();
            if(!actual.equals(expected[i])){
                System.out.printf("testCase %d:\nExpected %s\n Actual  %s\n", i, expected[i], actual);
                passed = false;
            }
        }

        System.out.printf("testReverseRecursive %s\n", passed ? "PASSED" : "FAILED");
    }

    private static SingleLinkedList arraytoLinkedList(int[] arr){
        SingleLinkedList result = new SingleLinkedList();
        for (int i: arr)
            result.add(i);
        return result;
    }



    private static void testListWithMultipleElements() {
        Item invalidItem = new Item(-1, false);
        SingleLinkedList list = new SingleLinkedList();

        // list as [-1, 1, 2]
        list.add(1);
        list.add(2);
        list.addFirst(-1);

        if (!assertEquals(list.size(), 3)) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(0), new Item(-1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(1), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(2), new Item(2, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.get(3), invalidItem)) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        list.removeLast();
        if (!assertEquals(list.get(0), new Item(-1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.getLast(), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        list.removeFirst();
        if (!assertEquals(list.get(0), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        if (!assertEquals(list.getLast(), new Item(1, true))) {
            System.out.println("testListWithOneElement FAILED");
            return;
        }
        System.out.println("testListWithOneElement PASSED");
    }

    private static void testToString() {
        SingleLinkedList list = new SingleLinkedList();
        assertTrue(list.toString().isEmpty());
        list.add(1);
        if (!assertEquals(list.toString(), "1 -> end")) {
            System.out.println("testToString FAILED");
            return;
        }
        list.add(2);
        if (!assertEquals(list.toString(), "1 -> 2 -> end")) {
            System.out.println("testToString FAILED");
            return;
        }
        System.out.println("testToString PASSED");
    }

    private static void testEmptyList() {
        Item invalidItem = new Item(-1, false);
        SingleLinkedList list = new SingleLinkedList();

        if (!assertEquals(list.size(), 0)) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertEquals(invalidItem, list.getFirst())) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertEquals(invalidItem, list.getLast())) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertEquals(invalidItem, list.get(0))) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        if (!assertTrue(list.toString().isEmpty())) {
            System.out.println("testEmptyList FAILED");
            return;
        }
        System.out.println("testEmptyList PASSED");
    }
}
