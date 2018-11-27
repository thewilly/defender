package org.weso.security.defender.client.configuration.impl;

import org.weso.security.defender.client.configuration.DefenderClientConfiguration;

public class DefenderClientConfigurationImpl implements DefenderClientConfiguration {
	
	private String host, port;
	
	public DefenderClientConfigurationImpl(String host, String port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public void setHost( String host ) {
		this.host = host;
	}

	@Override
	public void setPort( String port ) {
		this.port = port;
	}

	@Override
	public String getHost() {
		return this.host;
	}

	@Override
	public String getPort() {
		return this.port;
	}

}
