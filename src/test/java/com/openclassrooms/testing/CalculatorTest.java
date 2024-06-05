package com.openclassrooms.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {
	private static Instant startedAt;

	private Calculator calculatorUnderTest;

	@BeforeEach
	public void initCalculator() {
		System.out.println("Appel avant chaque test");
		calculatorUnderTest = new Calculator();
	}

	@Test
	public void testAddTwoPositiveNumbers() {
		// Arrange
		int a = 2;
		int b = 3;

		// Act
		int somme = calculatorUnderTest.add(a, b);

		// Assert assertEquals(5, somme);
		// AssertJ
		assertThat(somme).isEqualTo(5);
	}

	@Test
	public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
		// Arrange
		int a = 42;
		int b = 11;

		// Act
		int produit = calculatorUnderTest.multiply(a, b);

		// Assert assertEquals(462, produit);
		assertThat(produit).isEqualTo(462);
	}

	@AfterEach
	public void undefCalculator() {
		System.out.println("Appel après chaque test");
		calculatorUnderTest = null;
	}

	@BeforeAll
	static public void initStartingTime() {
		System.out.println("Appel avant tous les tests");
		startedAt = Instant.now();
	}

	@AfterAll
	static public void showTestDuration() {
		System.out.println("Appel après tous les tests");
		Instant endedAt = Instant.now();
		long duration = Duration.between(startedAt, endedAt).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}

	@ParameterizedTest(name = "{0} + {1} should equal to {2}")
	@CsvSource({ "1,1,2", "2,3,5", "42,57,99" })
	public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
		// Arrange -- Tout est prêt !

		// Act
		int actualResult = calculatorUnderTest.add(arg1, arg2);

		// Assert assertEquals(expectResult, actualResult);
		assertThat(actualResult).isEqualTo(expectResult);
	}

	/*
	 * @Timeout(1)
	 * 
	 * @Test public void longCalcul_shouldComputeInLessThan1Second() { // Arrange
	 * 
	 * // Act calculatorUnderTest.longCalculation();
	 * 
	 * // Assert // ... }
	 */

	/*
	 * @Test public void listDigits_shouldReturnsTheListOfDigits_ofPositiveInteger()
	 * { // GIVEN int number = 95897;
	 * 
	 * // WHEN Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);
	 * 
	 * // THEN Set<Integer> expectedDigits = Stream.of(5, 7, 8,
	 * 9).collect(Collectors.toSet()); assertEquals(expectedDigits, actualDigits); }
	 */
}
