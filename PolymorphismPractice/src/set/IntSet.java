package set;

public class IntSet {
	
	public static void main(String[] args) {
		IntSet set= new IntSet(10);
		IntSet set2= new IntSet(10);
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		set2.add(1);
		set2.add(3);
		set2.add(5);
		
		set.isSubsetOf(set2);
		System.out.println(set2);
		
		
		/*
		set.copyTo(set2);
		System.out.print(set2 );
		IntSet set3 = new IntSet(10);
		set2.add(1234);
		set3.unionOf(set, set2);
		System.out.println(set3);
		IntSet set4 = new IntSet(10);
		System.out.println(set4);
		*/
		
	}
	
	private int max;
	private int num;
	private int[] set;
	

	public IntSet (int capacity) {
		num=0;
		max=capacity;
		set=new int [max];
	}
	public boolean add(int data)
	{
		if (indexOf(data)!=-1) {
			return false;
		}
		if (num<max) {
		set[num] = data;
		num++;
		return true;
		}
		return false;
	}
	public int capacity() {
		return max;
	}
	public int size() {
		return num;
	}
	public int indexOf (int n) {
		for (int i=0; i<num; i++) {
			if (n==set[i]) {
				return i;
			}
		}
		return -1;
	}
	public boolean contains (int n) {
		if (indexOf(n)==-1) {
			return false;
		}
		return true;
		
		//return !(indexOf(n)==-1)
	}
	public boolean remove (int n) {
		if (indexOf(n)==-1)
			return false;
		for (int i=indexOf(n);i<num-1; i++) {
				set[i]=set[i+1];
			}
		num--;
		return true;
	}
	public String toString() {
		String result = "";
		for (int i=0; i<num; i++) {
			Integer a = new Integer(set[i]);
			result+=a.toString() +" ";
		}
		return result;
	}
	public void copyTo(IntSet s) {
		s.num=this.num;
		s.max=this.max;
		s.set=new int [max];
		for (int i=0; i< num; i++) {
			s.set[i]=set[i];
		}
	}
	public void copyFrom (IntSet s) {
		this.num=s.num;
		this.max=s.max;
		this.set = new int [max];
		
		for (int i=0; i<num; i++) {
			set[i]=s.set[i];
		}
		
		//s.copyTo(this);
	}
	public boolean equalTo(IntSet s) {
		if (s.num!=this.num) {
			return false;
		}
		if (s.num==this.num) {
			for (int i=0; i<num; i++) {
				if (this.contains(s.set[i]))		
					continue;
					else 
						return false;	
			}
			return true;
		}
		return false;
	}
	
	public void unionOf(IntSet s1, IntSet s2) {
		this.max=s1.max+s2.max;
		this.num=0;
		this.set=new int[max];
		for (int i=0; i<s1.num; i++) {
			this.add(s1.set[i]);
		}
		for (int i=0; i<s2.num; i++) {
			this.add(s2.set[i]);
		}
	}
	public boolean isEmpty() {
		if (num==0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if (num==max) {
			return true;
		}
		return false;
	}
	public void clear() { // 모든 숫자를 0으로 만든다는 뜻인가?
		
	}
	
	public boolean add(IntSet s) {
		for (int i=0; i<num; i++) {
			if (!(this.contains(s.set[i])))	{	
				this.add(s.set[i]);
				return true;
			}
		}
		return false;
	}
	public boolean retain (IntSet s) {//skip
		for (int i=0; i<s.num;) {
			if (this.contains(s.set[i])){
				for (int j=i; j<s.num-1; j++) {
				s.set[j]=s.set[j+1];
				}
				s.num--;
			}
			else {
				i++;
			}
			return true;
		}
		return false;
	}
	public boolean isSubsetOf(IntSet s) {
		int total =0;
		for (int i=0; i<s.num; i++) {
			if (this.contains(s.set[i])) {
				total++;
			}
		}
		if (total==s.num) {
			return true;
		}
		return false;
	}
	
	
	
	
	//boolean isEmpty()
	//boolean isFull()
	//void clear()
	
}
