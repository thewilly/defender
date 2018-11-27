package org.weso.security.defender.server.types;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import org.junit.Test;

import pl.pojo.tester.api.assertion.Method;

public class MetadataEntryTest {
	
	@Test
	public void autoTest() {
		assertPojoMethodsFor( MetadataEntry.class )
				.testing(
						Method.GETTER,
						Method.SETTER,
						Method.EQUALS,
						Method.HASH_CODE,
						Method.TO_STRING,
						Method.CONSTRUCTOR )
				.areWellImplemented();
	}

}
