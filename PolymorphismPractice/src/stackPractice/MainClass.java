package stackPractice;

class Node{
	int item;
	Node next;
	
	
}
//stack queue
//stack : push (아이템을 가장 위에다 넣기), pop (가장 위에 있는 거 꺼내기), top (가장 위에 있는 거 조회)
//queue: enque(맨뒤에다 넣기), deque (맨앞에 꺼내기), 
//stack: LIFO (last in first out) queue: FIFO (first in first out) 
class Stack{
	Node head;
	Stack(){
		head=null;
	}
	void push(int item) {
		Node new_node = new Node();
		new_node.item=item;
		new_node.next=head;
		head=new_node;
		
	}
	void pop() {
		if (head==null) {
			return; // 아무것도 안쓰면 그냥 함수를 종료해라. 
		}
		head=head.next;	
	}
	int top() {
		return head.item;
	}
}
class Queue {
	Node head;
	Node tail;
	Queue (){
		head = null;
		tail = null;
	}
	void enque(int item) {
		Node new_node = new Node();
		new_node.item=item;
		if (head == null) {
			head=new_node;
			tail=head;
			head.next=null; 
		}
		else {
			tail.next=new_node;
			tail=new_node;
		}
		
	}
	int deque() {
		if (head==tail) {
			int result = head.item;
			head=null;
			tail=null;
			return result;
		}
		int result = head.item;
		head = head.next;
		return result;
	}
}
public class MainClass {

	public static void main(String[] args) {
		Stack stk = new Stack();
		stk.push(10);
		stk.push(20);
		stk.push(30);
		System.out.println(stk.top());
		stk.pop();
		System.out.println(stk.top());
		stk.pop();
		System.out.println(stk.top());
		stk.pop();
		
		Queue q = new Queue ();
		q.enque(100);
		q.enque(200);
		q.enque(300);
		q.enque(400);
		q.enque(500);
		System.out.println(q.deque());
		System.out.println(q.deque());
		System.out.println(q.deque());
		
		
	}

}
