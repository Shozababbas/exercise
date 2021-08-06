package com.ER.exercise.service_impl_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.ER.exercise.request.Range;
import com.ER.exercise.service.impl.NumberServiceImpl;

public class NumberServiceImplTest {

	static Range range = null;
	NumberServiceImpl object;

	@BeforeAll
	public static void setupRange() {
		range = new Range(1l, 10l);

	}

	@BeforeEach
	public void setup() {
		object = new NumberServiceImpl();
	}

	@ParameterizedTest
	@ValueSource(longs = { 2, 6 })
	@DisplayName("checkIfNumberIsPerfect")
	public void checkIfNumberIsPerfectTest(Long number) {
		if (number == 2)
			Assertions.assertFalse(object.checkIfNumberIsPerfect(number));
		if (number == 6)
			Assertions.assertTrue(object.checkIfNumberIsPerfect(number));

	}

	@Test
	@DisplayName("checkAllNumbers")
	public void checkAllNumbersTest() {
		Assertions.assertNotNull(object.checkAllNumbers(range));
	}
}
