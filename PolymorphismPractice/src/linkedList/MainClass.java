package linkedList;

class Node{
	public int item;
	public Node next;
	Node (int new_item) {
		this.item=new_item;
	}
}

class List{
	Node head;
	Node tail;
	
	List(){
		head = null;
		head = tail;
	}
	public void add (int item) {
		if (head==null) {
			head = new Node(item);
			tail = head;
			tail.next=null;
		}
		else {
			tail.next = new Node(item);
			tail = tail.next;
			tail.next=null;
		}
	}
	public void clear() {
		head = null;
		tail = null;
	}
	public int indexOf(int item) {
		Node iter = head;
		int index = 0;
		while (iter!=null) {
			if (iter.item == item) {
				return index;
			}
			else {
				index++;
				iter=iter.next;
			}
		}
			return -1;
	}
		public int get (int index) {
			Node iter = head;
			for (int i=0; i<index; i++) {
				iter = iter.next;
				if (iter == null) {
					return -1;
				}
			}
			return iter.item;
			
		}
		public boolean isEmpty() {
			return head == null;
		}
		public int remove(int index) {
			Node iter= head;
			if (index ==0) {
				head = head.next;
				if (head == null) {
					tail=null;
				}
			}
			else 
			{
				for (int i=0; i<index-1; i++) 
				{
					iter=iter.next;
					if (iter.next==null) 
				{
						return -1;
				}
					iter.next=iter.next.next;
				}
			}
			return 0;
		}
		public int set (int index, int item) {
			Node iter= head;
			int idx =0;
			while (iter!=null && index>idx ) {
				iter=iter.next;
				idx++;
			}
			if (idx==index) {
				iter.item = item;
				return item;
			}
			else {
				return -1;
			}
		}
		public int size() {
			Node iter=head;
			int counter =0;
			if (isEmpty()) {
				return 0;
			}
			while (iter!=tail) {
				iter = iter.next;
				counter++;
			}
			return counter+1;
		}
		public String toString() {
			String result="";
			Node iter = head;
			if (iter ==null) {
				return "";
			}
			else {
				while (iter!=null) {
					result+=iter.item +" ";
					iter=iter.next;
				}
			}
			return result;
		}
	}


public class MainClass {
	public static void main(String[] args) {
		List intList = new List();
		intList.add(100);
		intList.add(200);
		intList.add(300);
		intList.add(400);
		intList.add(500);
		intList.add(600);
		intList.add(700);
		for (int i=0; i<intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		System.out.println(intList.indexOf(300));
		
		System.out.println(intList);
		
	}
	
	
/*
	
		Node head = new Node();
		head.item=100;
		head.next= null; // to show that "head" is the last
		
		Node temp = new Node ();
		temp.item = 200;
		temp.next = head;
		head = temp;
		
		temp = new Node ();
		temp.item=300;
		temp.next=head;
		head=temp;
		
		Node iterator = head;
		while (iterator!= null) {
			System.out.println(iterator.item);
			iterator = iterator.next; // 계속 다음꺼 print해주기
			
		}
	}
*/
}
