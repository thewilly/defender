package org.weso.security.services;

import java.util.HashMap;

import org.weso.security.types.APIToken;


public interface APITokensService {
	
	public void register(HashMap<String, Object> metadata);
	
	//public APIToken getdAPIToken(String token);

}
