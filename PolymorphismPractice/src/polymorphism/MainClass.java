package polymorphism;

class Human{
	protected int age;
	public void info() {
		System.out.println("wow");
	}
}
class Student extends Human{
	@Override
	public void info() {
		System.out.println("�����ϱ� �ȴ�"+age);
	}
	public void study() {
		System.out.println("I am studying.");
	}
}

class Teacher extends Human{
	public void info() {
		System.out.println("i'm a teacher.");
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		Human h1= new Student (); //info�Լ��� student���� �����.
		//Student std1 = new Human(); --> ����, 
		h1.info();
		//h1.study(); --> ����, parent class�� ���� �Լ��̹Ƿ�.f
		//std1.info();
		Human h2 = new Teacher();
		h2.info();
		
		Human array [] = new Human[10];
		for (int i=0; i<array.length; i++) {
			if (i%3==0) {
				array[i] = new Teacher();
			}
			else if (i%3==1) {
				array[i] = new Student();
			}
			else {
				array[i] = new Human();
			}
			
		}
		for (int i =0; i<array.length; i++) {
			array[i].info();
		}

	}

}
