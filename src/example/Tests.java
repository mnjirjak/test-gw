package example;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class TestCalculator {
	
	@Test
	void testAdd1() {
		assertEquals(5, Calculator.add(2, 3));
	}
	
	@Test
	void testAdd2() {
		assertEquals(1, Calculator.add(-2, 3));
	}
	
	@Test
	void testAdd3() {
		assertEquals(-1, Calculator.add(2, -3));
	}
	
	@Test
	void testAddAll() {
		assertAll(
				() -> assertEquals(5, Calculator.add(2, 3)),
				() -> assertEquals(1, Calculator.add(-2, 3)),
				() -> assertEquals(-1, Calculator.add(2, -3))
		);
	}
	
	@Test
	@DisplayName("Add - both negative")
	@Tag("bothNegative")
	void testAdd4() {
		assertEquals(-5, Calculator.add(-2, -3));
	}
	
	@Nested
	class testSubtract {
		
		@Test
		void testSubtract1() {
			assertEquals(-1, Calculator.subtract(2, 3));
		}
		
		@Test
		void testSubtract2() {
			assertEquals(1, Calculator.subtract(5, 4));
		}
		
	}
	
	@BeforeAll
	static void beforeAllTests() {
		System.out.println("Before the tests");
	}
	
	@AfterAll
	static void afterAllTests() {
		System.out.println("After the tests");
	}
	
	@BeforeEach
	void beforeEachTest() {
		System.out.println("Before each test");
	}
	
	@AfterEach
	void afterEachTest() {
		System.out.println("After each test");
	}
	
	@TestFactory
	Collection<DynamicTest> dynamicTests() throws IOException {
		List<DynamicTest> tests = new ArrayList<>();
		int num = 1;
		
		BufferedReader br = new BufferedReader(new FileReader("src/example/testSubtract.csv"));
	    String line;
	    
		while ((line = br.readLine()) != null) {
		    String[] values = line.split(",");
		    tests.add(
		    		DynamicTest.dynamicTest(
		    				"Subtract auto test " + num++,
		    				() -> assertEquals(Integer.parseInt(values[2]),
		    								   Calculator.subtract(
		    										   Integer.parseInt(values[0]),
		    										   Integer.parseInt(values[1]))
		    				)
		    		)
		    );
		    		
		}
		
		br.close();
		
		return tests;
	}

	@RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	void testMultiply(RepetitionInfo repetitionInfo) {
		assertEquals(-6, Calculator.multiply(2, -3));
	}
	
	@ParameterizedTest
	//@CsvSource({"2,3,0.66666", "5,5,1", "8,4,2"})
	@CsvFileSource(resources = "/example/testDivide.csv")
	void testDivide(double first, double second, double solution) {
		assertEquals(solution, Calculator.divide(first, second), 0.001);
	}
	
}
