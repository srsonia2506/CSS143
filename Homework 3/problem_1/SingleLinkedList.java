public class SingleLinkedList {

    private ListNode head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    public SingleLinkedList(SingleLinkedList list) {
        head = new ListNode();
        head =list.head;
        head.next=list.head.next;
    }

    public int remove(int valueToRemove) {
        int count=0;
		ListNode next=null, curr = head;
		
		while (curr != null){
			next=curr.next;
			if (next != null && next.val == valueToRemove){
				curr.next = next.next;
				next.next=null;
				count++;
			} else {
				curr = curr.next;
			}
		}
		return count;
    }

    public void reverseIterative() {     
      ListNode curr = head.next, prev = null, next = null;

      while(curr != null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
      }
      head.next=prev;
    }

    static ListNode merge(ListNode start1, ListNode end1,ListNode start2, ListNode end2){ 
  
    // Making sure that first node of second 
    // list is higher. 
    ListNode temp = null; 
    if ((start1).val > (start2).val)  
    { 
        ListNode t = start1; 
        start1 = start2; 
        start2 = t; 
        t = end1; 
        end1 = end2; 
        end2 = t; 
    } 
  
    ListNode astart = start1, aend = end1; 
    ListNode bstart = start2, bend = end2; 
    ListNode bendnext = (end2).next; 
    while (astart != aend && bstart != bendnext){ 
        if (astart.next.val > bstart.val){ 
            temp = bstart.next; 
            bstart.next = astart.next; 
            astart.next = bstart; 
            bstart = temp; 
        } 
        astart = astart.next; 
    } 

    if (astart == aend) 
        astart.next = bstart; 
    else
        end2 = end1; 
          
        return start1; 
    }

    public void mergeSorted(SingleLinkedList listToMerge) {
      if (head == null) 
        return ; 
      ListNode start1 = null, end1 = null; 
      ListNode start2 = null, end2 = null; 
      ListNode prevend = null; 
      int len = size; 
    
      for (int gap = 1; gap < len; gap = gap*2){ 
          start1 = head; 
          while (start1 != null){ 
    
              // If this is first iteration 
              boolean isFirstIter = false; 
              if (start1 == head) 
                  isFirstIter = true; 
    
              // First part for merging 
              int counter = gap; 
              end1 = start1; 
              while (--counter > 0 && end1.next != null) 
                  end1 = end1.next; 
    
              // Second part for merging 
              start2 = end1.next; 
              if (start2 == null) 
                  break; 
              counter = gap; 
              end2 = start2; 
              while (--counter > 0 && end2.next != null) 
                  end2 = end2.next; 
    
              // To store for next iteration. 
              ListNode temp = end2.next; 
    
              // Merging two parts. 
              merge(start1, end1, start2, end2); 
    
              // Update head for first iteration, else 
              // append after previous list 
              if (isFirstIter) 
                  head = start1; 
              else
                  prevend.next = start1; 
    
              prevend = end2; 
              start1 = temp; 
          } 
          prevend.next = start1; 
      } 
      return; 
    }

    int size() {
        return size;
    }

    public Item getFirst() {
        return get(0);
    }

    public Item getLast() {
        return get(size-1);
    }

    // Returns the element at the specified position in this list
    public Item get(int index) {
        if (index<0 || index>=size) {
            return new Item(-1, false);
        }
        ListNode ptr = head.next;
        for (int i=0; i<index; i++) {
            if (ptr==null) {
                return new Item(-1, false);
            }
            ptr = ptr.next;
        }
        return new Item(ptr.val, true);
    }

    // Appends the specified element to the end of this list
    public void add(int val) {
        size++;
        ListNode ptr = head;
        while (ptr.next!=null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(val);
    }

    // Inserts the specified element at the beginning of this list
    public void addFirst(int val) {
        size++;
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    // Removes and returns the first element from this list
    public void removeFirst() {
        if (head.next==null) {
            return;
        }
        head.next = head.next.next;
        size--;
    }

    // Removes and returns the last element from this list
    public void removeLast() {
        if (head.next == null) {
            return;
        }
        size--;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2.next!=null) {
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr!=null) {
            builder.append(ptr.val + (ptr.next==null ? " -> end " : " -> "));
            ptr = ptr.next;
        };

        return builder.toString();
    }
	
	public boolean equals(SingleLinkedList listb){
        ListNode a = this.head;
        ListNode b = listb.head;

        while (a != null && b != null)
        {
            if (a.val != b.val) {
                return false;
            }
            /* If we reach here, then a and b are not null
               and their data is same, so move to next nodes
               in both lists */
            a = a.next;
            b = b.next;
        }

        return (a == null && b == null);//both are are equal at this point
    }


}

