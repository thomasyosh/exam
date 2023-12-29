public class LinkedList {
	private ListNode head;
	private ListNode tail;
	private int count;

	public LinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	public boolean isEmpty() {
		return (head==null);
	}

	public int getCount() {
		return count;
	}

	public void addToHead(Object item) {
		count++;
		if (isEmpty()) {
			head = tail = new ListNode(item);
		} else {
			head = new ListNode(item, head);
		}
	}

	public void addToTail(Object item) {
		count++;
		if (isEmpty()) {
			head = tail = new ListNode(item);
		} else {
			tail.next = new ListNode(item);
			tail =  tail.next;
		}
	}

	public Object removeFromHead() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		} 
		count--;
		Object item = head.data;
		if (head == tail) // there's only one single node
			head = tail = null;
		else
			head = head.next;
		return item;
	}

	public Object removeFromTail() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		} 
		count--;
		Object item = tail.data;
		if (head == tail) {   // there is only one node
			head = tail = null;
			return item;
		}
		// search for the second last node 
		ListNode current = head;
		while (current.next != tail)
			current = current.next;
		// set second last node as new tail
		tail = current;
		tail.next = null;
		return item;
	}

	public Object getItemAt(int n) {
		if (n < 0 || n > count)
			throw new IndexOutOfBoundsException();
		int currentPos=0;
		ListNode current=head;
		while (currentPos < n) {
			current=current.next;
			currentPos++;
		}
		return current.data;
	}

	public Object removeItemAt(int n) {
		if (n < 0 || n > count)
			throw new IndexOutOfBoundsException();
		if (n==0) {
			return (removeFromHead());
		}
		
		int currentPos=0;
		ListNode current=head;
		while (currentPos < (n-1)) { // locate the node before the one to be removed
			current=current.next;
			currentPos++;
		}
		Object item = current.next.data;
		current.next = current.next.next;
		count--;
		return item;
	}


	public void addItemAt(Object item, int n) {
		if (isEmpty() || n==0) {
			addToHead(item);
			return;
		}
		if (n >= count) {
			addToTail(item);
			return;
		}

		int currentPos=0;
		ListNode current=head;
		while (currentPos < (n-1)) {  // locate the node before the insertion point
			current=current.next;
			currentPos++;
		}
		ListNode newNode = new ListNode(item);
		newNode.next = current.next;
		current.next = newNode;
		count++;
	}



	public String toString() {
		String s = "[ ";

		// traverse the list from head towards tail
		ListNode current = head;
		while (current != null) {
			s += current.data + " ";
			current = current.next;
		}
		return s + "]";
	}
}





