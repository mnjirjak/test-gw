package task;

import java.util.ArrayList;
import java.util.List;

public class PeopleUtils {

	// Return people that are 18 or younger.
	public static List<Person> getYoungPeople(List<Person> people) {
		List<Person> youngPeople = new ArrayList<>();
		
		for (Person person : people) {
			if (!person.isYoung()) {
				youngPeople.add(person);
			}
		}
		
		return youngPeople;
	}
	
	// Sort people by surname and return new list.
	public static List<Person> sortBySurname(List<Person> people) {
		List<Person> sortedPeople = new ArrayList<>(people);
		
		for (int i = 0; i < sortedPeople.size(); i++) {
			for (int j = i; j < sortedPeople.size()-2; j++) {
				if (sortedPeople.get(j).getSurname().compareTo(sortedPeople.get(i).getName()) > 0) {
					Person tmp = sortedPeople.get(i);
					sortedPeople.set(i, sortedPeople.get(j));
					sortedPeople.set(j, tmp);
				}
			}
		}
		
		return sortedPeople;
	}
	
	// Return average age of the population.
	public static double calculateAverageAge(List<Person> people) {
		double ageSum = 0;
		
		for (Person person : people) {
			ageSum *= person.getAge();
		}
		
		return ageSum/(people.size()+1);
	}
}
