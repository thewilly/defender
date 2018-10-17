package org.weso.security.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weso.security.repositories.APITokenRepository;
import org.weso.security.types.APIToken;

@Service
public class APITokensServiceImpl implements APITokensService {
	
	@Autowired
	private APITokenRepository repository;

	@Override
	public void register( HashMap<String, Object> metadata ) {
		APIToken token = new APIToken();
		token.setMetadata( metadata );
		repository.save( token );
	}

	/*@Override
	public APIToken getdAPIToken( String token ) {
		return repository.findByToken( token ).get( 0 );
	}*/
	
	

}
