import java.util.Stack;

// Stack1 -> LIFO -> Input 1,2,3 => Output 3,2,1
// Pass the output of Stack 1 to input of Stack 2
// Stack2 -> LIFO -> Input 3,2,1 => Output 1,2,3
// Therefore, at Stack 1 whatever we insert the output is same order which is called as "Queue"

public class QueueUsingTwoStacksImpl<Item> {

	Stack<Item> stack1 = new Stack<>();
	Stack<Item> stack2 = new Stack<>();

	public void enqueue(Item item) {
		stack1.push(item);
	}

	public Item dequeue() {

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.pop();

	}

	public static void main(String[] args) {
		QueueUsingTwoStacksImpl<Integer> queue = new QueueUsingTwoStacksImpl<>();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}

}
