package org.weso.security.defender.server.types;

import static org.junit.Assert.*;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.Test;

import pl.pojo.tester.api.assertion.Method;

public class OneTimeTokenTest {

	@Test
	public void lenghtTest() {
		assertEquals( 512, new OneTimeToken().value().length() );
	}
	
	@Test
	public void constructorTest() {
		OneTimeToken tokenObject = new OneTimeToken();
		assertNotNull( tokenObject );
	}
	
	@Test
	public void singleAccessTest() {
		OneTimeToken tokenObject = new OneTimeToken();
		
		// The first access should not be null
		assertNotNull(tokenObject.value());
		
		// Second access the token should be destroyed and no longer accesible.
		assertNull(tokenObject.value());
	}
	
	@Test
	public void autoTest() {
		assertPojoMethodsFor( OneTimeToken.class )
				.testing(
						Method.CONSTRUCTOR )
				.areWellImplemented();
	}

}
