package linkedList2;

class Item {
	
}
class Node{
	public String item;
	public Node next;
	Node (String new_item) {
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
	public void add (String item) {
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
	public int indexOf(String item) {
		Node iter = head;
		int index = 0;
		while (iter!=null) {
			if (iter.item.equals(item)) {
				return index;
			}
			else {
				index++;
				iter=iter.next;
			}
		}
			return -1;
	}
		public String get (int index) {
			Node iter = head;
			for (int i=0; i<index; i++) {
				iter = iter.next;
				if (iter == null) {
					return "None";
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
		public String set (int index, String item) {
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
				return "None";
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
		intList.add("minseok");
		intList.add("yoonjae");
		intList.add("minhong");
		for (int i=0; i<intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		System.out.println(intList.indexOf("minseok"));
		
		System.out.println(intList);
		
	}
	
	

}





//stack queue
//stack : push (아이템을 가장 위에다 넣기), pop (가장 위에 있는 거 꺼내기), top (가장 위에 있는 거 조회)
//queue: enque(맨뒤에다 넣기), deque (맨앞에 꺼내기), 
//stack: LIFO (last in first out) queue: FIFO (first in first out) 

