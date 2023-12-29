public class LinkedList {
	private ListNode head;
	private ListNode tail;
	private Comparator comparator;

	public LinkedList() {
		head = null;
		tail = null;
		comparator = null;
	}

	public LinkedList(Comparator comparator) {
		head = null;
		tail = null;
		this.comparator = comparator;
	}

	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
	}

	public boolean isEmpty() {
		return (head==null);
	}

	public void insertInOrder(Object item) {
		if (isEmpty()) {
			head = tail = new ListNode(item);
		} else {
			if (comparator.isGreaterThanOrEqualTo(head.data, item)) {
				addToHead(item);
			} else if (comparator.isLessThanOrEqualTo(tail.data, item)) {
				addToTail(item);
			} else {
				ListNode current = head;
				while (current.next != null) {
					if (comparator.isGreaterThanOrEqualTo(current.next.data, item)) {
						ListNode newNode = new ListNode(item);
						newNode.next = current.next;
						current.next = newNode;
						return;
					}
					current = current.next;
				}
			}
		}
	}

	public void removeItem(Object item) throws ItemNotFoundException {
		if (isEmpty()) {
			throw new ItemNotFoundException();
		} 

		if (comparator.isEqualTo(head.data, item)) 
			removeFromHead();
		else if (comparator.isEqualTo(tail.data, item)) 
			removeFromTail();
		else {
			ListNode current = head;
			while (current.next != null) {
				if (comparator.isEqualTo(current.next.data, item)) {
					current.next = current.next.next;
					return;
				}
				current = current.next;
			}
			throw new ItemNotFoundException();
		}
	}

	public void addToHead(Object item) {
		if (isEmpty()) {
			head = tail = new ListNode(item);
		} else {
			head = new ListNode(item, head);
		}
	}

	public void addToTail(Object item) {
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





