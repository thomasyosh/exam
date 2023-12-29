public class Test {
	public static void main(String [] args) {
		Stack stack1 = new ArrayStack(2);
		stack1.push(25);
		stack1.push(125);

		Stack stack2 = new LinkedStack();
		stack2.push(5);
		stack2.push(515);
		System.out.println(stack2.size());



	}
}

