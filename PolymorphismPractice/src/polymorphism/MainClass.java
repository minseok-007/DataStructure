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
		System.out.println("공부하기 싫다"+age);
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
		Human h1= new Student (); //info함수를 student껄로 덮어씌움.
		//Student std1 = new Human(); --> 오류, 
		h1.info();
		//h1.study(); --> 오류, parent class에 없는 함수이므로.f
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
