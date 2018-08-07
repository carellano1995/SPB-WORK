package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import workshop.spring.boot.workshopspringboot.validations.RutValidator;

public class validateRutTest {

	@Test
	public void validateRut() {
		assertTrue(RutValidator.isValid("19023819-9"));
	}

	@Test
	public void validateFakeRut() {
		assertFalse(RutValidator.isValid("19023819-4"));
	}

	@Test
	public void validateRutWithPoint() {
		assertTrue(RutValidator.isValid("19.023.819-9"));
	}

}
