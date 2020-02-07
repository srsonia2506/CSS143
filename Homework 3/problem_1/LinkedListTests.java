public class LinkedListTests extends Tests {

    public static void testAll() {
        testCopyConstructor();
        testRemove();
        testReverseIterative();
        testMergeSorted();
        testEmptyList();
        testListWithMultipleElements();
        testToString();
    }

    public static void testCopyConstructor() {
        // homework
        boolean allCopyPass = true;

        SingleLinkedList listEmpty = new SingleLinkedList();//empty list
        SingleLinkedList listEmptyCopy = new SingleLinkedList(listEmpty);

        if(!listEmpty.equals(listEmptyCopy)){
            System.out.println("Error in empty list testing something went wrong with your comparison");
            allCopyPass = false;
        }

        SingleLinkedList listOne = new SingleLinkedList();// list with one node
        listOne.add(5);
        SingleLinkedList listOneCopy = new SingleLinkedList(listOne);
        if(!listOne.equals(listOneCopy)){
            System.out.printf("Error in list with one node, \nexpected: %s \nactual:   %s \n", listOne.toString(), listOneCopy.toString());
            allCopyPass = false;
        }


        SingleLinkedList listTwo = new SingleLinkedList();//list with two nodes, different values
        SingleLinkedList listTwoCopy = new SingleLinkedList(listTwo);
        listTwo.add(1);
        listTwo.add(2);
        if(!listTwo.equals(listTwoCopy)){
            System.out.printf("Error in list with two nodes, \nexpected: %s \nactual:   %s \n", listTwo.toString(), listTwoCopy.toString());
            allCopyPass = false;
        }


        SingleLinkedList listTwoSame = new SingleLinkedList();//list with two nodes, different values
        SingleLinkedList listTwoSameCopy = new SingleLinkedList(listTwoSame);
        listTwoSame.add(1);
        listTwoSame.add(1);
        if(!listTwo.equals(listTwoCopy)){
            System.out.printf("Error in list with two nodes of the same value, \nexpected: %s \nactual:   %s \n", listTwoSame.toString(), listTwoSameCopy.toString());
            allCopyPass = false;
        }


        SingleLinkedList listThree = new SingleLinkedList();//list with three nodes, different values
        SingleLinkedList listThreeCopy = new SingleLinkedList(listThree);
        listThree.add(1);
        listThree.add(2);
        listThree.add(3);
        if(!listThree.equals(listThreeCopy)){
            System.out.printf("Error in list with three nodes, \nexpected: %s \nactual:   %s \n", listThree.toString(), listThreeCopy.toString());
            allCopyPass = false;
        }

        if(!allCopyPass){
            System.out.println("testCopyConstructor FAILED");
        }else{
            System.out.println("testCopyConstructor PASSED");
        }

    }

    public static void testRemove() {
        boolean allCasePassed = true;

        SingleLinkedList listRemovePass = new SingleLinkedList();
        listRemovePass.add(2);
        listRemovePass.add(3);

        SingleLinkedList listRemove = new SingleLinkedList(); //list 1 [1,2,3]
        listRemove.add(1);
        listRemove.add(2);
        listRemove.add(3);
        listRemove.remove(1); //list after [2,3]


        if(!listRemove.equals(listRemovePass)){
            System.out.printf("Error in case 1: \nexpected: %s\nactual:   %s\n", listRemovePass.toString(), listRemove.toString());
            allCasePassed = false;
        }

        SingleLinkedList listRemovePass2 = new SingleLinkedList();
        listRemovePass2.add(1);
        listRemovePass2.add(4);

        SingleLinkedList listRemove2 = new SingleLinkedList(); //list 2 [1,2,4,2]
        listRemove2.add(1);
        listRemove2.add(2);
        listRemove2.add(4);
        listRemove2.add(2);
        listRemove2.remove(2); //list after [1,4]

        if(!listRemove2.equals(listRemovePass2)){
            System.out.printf("Error in case 2: \nexpected: %s\nactual:   %s\n", listRemovePass2.toString(), listRemove2.toString());
            allCasePassed = false;
        }

        SingleLinkedList listRemovePass3 = new SingleLinkedList();
        listRemovePass3.add(4);
        listRemovePass3.add(2);

        SingleLinkedList listRemove3 = new SingleLinkedList(); //list 3 [1,1,4,2]
        listRemove3.add(1);
        listRemove3.add(1);
        listRemove3.add(4);
        listRemove3.add(2);
        listRemove3.remove(1); //list after [4,2]

        if(!listRemove3.equals(listRemovePass3)){
            System.out.printf("Error in case 3: \nexpected: %s\nactual:   %s\n", listRemovePass3.toString(), listRemove3.toString());
            allCasePassed = false;
        }

        SingleLinkedList listRemovePass4 = new SingleLinkedList();

        SingleLinkedList listRemove4 = new SingleLinkedList(); //list 4 [3,3,3,3]
        listRemove4.add(3);
        listRemove4.add(3);
        listRemove4.add(3);
        listRemove4.add(3);
        listRemove4.remove(3); //list after []

        if(!listRemove4.equals(listRemovePass4)){
            System.out.printf("Error in case 4: \nexpected %s\nactual:   %s\n", listRemovePass4.toString(), listRemove4.toString());
            allCasePassed = false;
        }

        SingleLinkedList listRemovePass5 = new SingleLinkedList();
        listRemovePass5.add(1);
        listRemovePass5.add(1);
        listRemovePass5.add(4);
        listRemovePass5.add(2);

        SingleLinkedList listRemove5 = new SingleLinkedList(); //list 5 [1,1,4,2]
        listRemove5.add(1);
        listRemove5.add(1);
        listRemove5.add(4);
        listRemove5.add(2);
        listRemove5.remove(5); //list after [1,1,4,2]

        if(!listRemove5.equals(listRemovePass5)){
            System.out.printf("Error in case 5: \nexpected %s\nactual:  %s\n", listRemovePass5.toString(), listRemove5.toString());
            allCasePassed = false;
        }

        if(!allCasePassed){
            System.out.println("testRemove FAILED");
        }else{
            System.out.println("testRemove PASSED");
        }
    }

    public static void testReverseIterative() {
        boolean allCasePassed = true;

        SingleLinkedList empty = new SingleLinkedList();
        SingleLinkedList emptyPass = new SingleLinkedList();
        empty.reverseIterative();

        if(!empty.equals(emptyPass)){
            System.out.println("Error in case 1 (empty case)");
            allCasePassed = false;
        }

        SingleLinkedList eleOne = new SingleLinkedList();
        eleOne.add(1);
        SingleLinkedList eleOnePass = new SingleLinkedList();
        eleOnePass.add(1);

        if(!eleOne.equals(eleOnePass)){
            System.out.printf("Error in case 2 (1 element)\nexpected: %s\nactual:   %s\n", eleOnePass.toString(), eleOne.toString());
            allCasePassed = false;
        }

        SingleLinkedList eleTwo = new SingleLinkedList();
        eleTwo.add(5);
        eleTwo.add(6);

        SingleLinkedList eleTwoPass = new SingleLinkedList();
        eleTwoPass.add(6);
        eleTwoPass.add(5);

        eleTwo.reverseIterative();
        if(!eleTwo.equals(eleTwoPass)){
            System.out.printf("Error in case 3 (2 elements no duplicates)\nexpected: %s\nactual:   %s\n", eleTwoPass.toString(), eleTwo.toString());
            allCasePassed = false;
        }

        SingleLinkedList eleTwoDupe = new SingleLinkedList();
        eleTwoDupe.add(5);
        eleTwoDupe.add(5);

        SingleLinkedList eleTwoDupePass = new SingleLinkedList();
        eleTwoDupePass.add(5);
        eleTwoDupePass.add(5);

        eleTwoDupe.reverseIterative();
        if(!eleTwoDupe.equals(eleTwoDupePass)){
            System.out.printf("Error in case 4 (2 elements with duplicates)\nexpected: %s\nactual:   %s\n", eleTwoDupePass.toString(), eleTwoDupe.toString());
            allCasePassed = false;
        }

        SingleLinkedList eleThree = new SingleLinkedList();
        eleThree.add(9);
        eleThree.add(7);
        eleThree.add(5);

        SingleLinkedList eleThreePass = new SingleLinkedList();
        eleThreePass.add(5);
        eleThreePass.add(7);
        eleThreePass.add(9);

        eleThree.reverseIterative();
        if(!eleThree.equals(eleThreePass)){
            System.out.printf("Error in case 5 (3 elements no duplicates)\nexpected: %s\nactual:   %s\n", eleThreePass.toString(), eleThree.toString());
            allCasePassed = false;
        }

        SingleLinkedList eleFive = new SingleLinkedList();
        eleFive.add(1);
        eleFive.add(2);
        eleFive.add(3);
        eleFive.add(4);
        eleFive.add(5);

        SingleLinkedList eleFivePass = new SingleLinkedList();
        eleFivePass.add(5);
        eleFivePass.add(4);
        eleFivePass.add(3);
        eleFivePass.add(2);
        eleFivePass.add(1);

        eleFive.reverseIterative();
        if(!eleFive.equals(eleFivePass)){
            System.out.printf("Error in case 6 (5 elements no duplicates)\nexpected: %s\nactual:   %s\n", eleFivePass.toString(), eleFive.toString());
            allCasePassed = false;
        }

        if(!allCasePassed){
            System.out.println("testReverseIterative FAILED");
        }else{
            System.out.println("testReverseIterative PASSED");
        }
    }

    public static void testMergeSorted() {
        boolean allPass = true;

        //case empty
        SingleLinkedList empty = new SingleLinkedList();
        SingleLinkedList emptyPass = new SingleLinkedList();

        if(!empty.equals(emptyPass)){
            System.out.printf("Error in combine empty cases\nexpected: %s\nactual:  %s", empty.toString(), emptyPass.toString());
            allPass = false;
        }

        SingleLinkedList case1 = new SingleLinkedList();
        case1.add(7);
        case1.add(8);
        case1.add(9);

        SingleLinkedList case1Add = new SingleLinkedList();

        SingleLinkedList final1 = new SingleLinkedList();
        final1.add(7);
        final1.add(8);
        final1.add(9);

        case1.mergeSorted(case1Add);

        if(!case1.equals(final1)){
            System.out.printf("Error in adding nothing to a linked list\nExpected: %s\nActual: %s\n", final1.toString(), case1.toString());
            allPass = false;
        }

        if(!allPass){
            System.out.println("testMergedSorted FAILED");
        }else{
            System.out.println("testMergedSorted PASSED");
        }
    }

    private static void testListWithMultipleElements() {
        Item invalidItem = new Item(-1, false);
        SingleLinkedList list = new SingleLinkedList();

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
