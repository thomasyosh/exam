public class QueueTest {
	public static void main(String [] args) {
		Queue queue = new LinkedQueue();

		Queue queue2 = new ArrayQueue();

		 queue.enqueue("Alex");
		 queue.enqueue("Sandy");
		 queue.enqueue("Betty");
		 //System.out.println(queue);

		 System.out.println("Removed: " + queue.dequeue());
		 //System.out.println(queue);
		 System.out.println("Removed: " + queue.dequeue());
		 //System.out.println(queue);
		 System.out.println("Removed: " + queue.dequeue());
		 //System.out.println(queue);

		queue2.enqueue("LAM WAI HIN");
		queue2.enqueue("POON YUK HO");

		System.out.println(queue2);
	}
}
