package org.weso.security.defender.client;

import org.weso.security.defender.client.configuration.DefenderClientConfiguration;
import org.weso.security.defender.client.connectors.MetadataEntryConnector;
import org.weso.security.defender.client.connectors.impl.MetadataEntryConnectorImpl;

public final class DefenderClient {
	
	private MetadataEntryConnector connector;
	
	public DefenderClient(DefenderClientConfiguration configuration) {
		this.connector = new MetadataEntryConnectorImpl( configuration );
	}
	
	public String requestToken() {
		return this.connector.requestToquen();
	}

}
