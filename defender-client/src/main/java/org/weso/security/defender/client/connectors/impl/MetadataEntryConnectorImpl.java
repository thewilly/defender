package org.weso.security.defender.client.connectors.impl;

import org.weso.security.defender.client.configuration.DefenderClientConfiguration;
import org.weso.security.defender.client.connectors.MetadataEntryConnector;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.javafx.collections.MappingChange.Map;

public class MetadataEntryConnectorImpl implements MetadataEntryConnector {
	
	private DefenderClientConfiguration configuration;
	
	public MetadataEntryConnectorImpl(DefenderClientConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public String requestToquen() {
		
		try {
			HttpResponse<JsonNode> response = 
					Unirest.get( this.configuration.getHost() + ":" + this.configuration.getPort() + "/register" )
						.asJson();
			System.out.println( response.getBody().getObject() );
			return response.getBody().getObject().get( "token" ).toString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public JsonNode getMetadataForToken( String token ) {
		
		// TODO Auto-generated method stub
		return new JsonNode("");
	}

	@Override
	public JsonNode saveMetadataForToken( String token, Map<String, Object> metadata ) {
		// TODO Auto-generated method stub
		return new JsonNode("");
	}

}
