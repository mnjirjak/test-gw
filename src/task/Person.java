package task;

public class Person {
	
	private String name, surname;
	private int age;

	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public boolean isYoung() {
		return age <= 18;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
}
