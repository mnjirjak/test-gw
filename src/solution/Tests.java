package solution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Tests {

	@ParameterizedTest
	@CsvFileSource(resources = "/solution/testSort.csv")
	void testSort(String testCase) {
		String values[] = testCase.split("#");
		String cases[] = values[0].split(";");
		
		List<Person> people = new ArrayList<>();
		
		for (String caseString : cases) {
			String caseValues[] = caseString.split(" ");
			Person person = new Person(caseValues[0], caseValues[1], Integer.parseInt(caseValues[2]));
			people.add(person);
		}
		
		people = PeopleUtils.sortBySurname(people);
		String result = "";
		
		for (Person person : people) {
			result += person.getSurname() + " ";
		}
		
		assertEquals(values[1] + " ", result);
	}
	
	@Test
	void testYoungAge() {
		List<Person> people = new ArrayList<>();

		people.add(new Person("Michael", "Perry", 18));
		people.add(new Person("Anna", "Smith", 17));
		people.add(new Person("Kevin", "Case", 19));
		
		final List<Person> sortedPeople  = PeopleUtils.getYoungPeople(people);

		assertAll(
				() -> assertEquals(2, sortedPeople.size()),
				() -> assertTrue(sortedPeople.get(0).getAge() <= 18),
				() -> assertTrue(sortedPeople.get(1).getAge() <= 18)
		);
	}
	
	@Test
	void testAverageAge() {
		List<Person> people = new ArrayList<>();

		people.add(new Person("Michael", "Perry", 18));
		people.add(new Person("Anna", "Smith", 17));
		people.add(new Person("Kevin", "Case", 19));
		people.add(new Person("Dana", "Ivy", 60));
		people.add(new Person("John", "Welch", 41));
		
		assertEquals(31.0, PeopleUtils.calculateAverageAge(people), 0.001);
	}

}
