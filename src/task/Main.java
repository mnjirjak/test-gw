package task;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Emma", "Jackson", 15));
		people.add(new Person("John", "Johnson", 65));
		people.add(new Person("Lily", "Broderick", 8));
		people.add(new Person("Tina", "Dean", 48));

		people = PeopleUtils.sortBySurname(people);
		
		for (Person person : people) {
			System.out.println(person.getSurname());
		}
		
		System.out.println();
		
		List<Person> young_people = PeopleUtils.getYoungPeople(people);
		
		for (Person person : young_people) {
			System.out.println(person.getSurname());
		}
		
		System.out.println();
		
		System.out.println(PeopleUtils.calculateAverageAge(people));
	}
	
}
