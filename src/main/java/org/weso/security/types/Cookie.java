package org.weso.security.types;

import java.util.HashMap;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

/**
 * Representation of an token for an API. The token must be unique and it
 * contains an info.
 *
 * @author Guillermo Facundo Colunga
 * @version 201806032143
 * @since 201806032143
 * @formatter Oviedo Computing Community
 */
@Data
@DynamoDBTable(tableName = "api-tokens")
public class Cookie {

	public Cookie() {}

	@DynamoDBHashKey
	public String token;

	@DynamoDBAttribute
	public HashMap<String, Object> metadata;
}
