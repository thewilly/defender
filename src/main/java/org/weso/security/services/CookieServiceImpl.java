package org.weso.security.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weso.security.repositories.CookiesRepository;
import org.weso.security.types.Cookie;

@Service
public class CookieServiceImpl implements CookieService {

	@Autowired
	private CookiesRepository repository;

	@Override
	public void register( HashMap<String, Object> metadata ) {
		Cookie token = new Cookie();
		token.setMetadata( metadata );
		repository.save( token );
	}

	@Override
	public Cookie getCookie( String token ) {
		return repository.findByToken( token );
	}

}
