package org.weso.security.defender.client;

import org.junit.Test;
import org.weso.security.defender.client.configuration.impl.DefenderClientConfigurationImpl;

public class DefenderClientTest {
	
	private DefenderClient client = new DefenderClient( new DefenderClientConfigurationImpl("http://localhost", "8082") );

	@Test
	public void test() {
		System.out.println(client.requestToken());
	}

}
