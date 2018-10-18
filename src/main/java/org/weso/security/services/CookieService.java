package org.weso.security.services;

import java.util.HashMap;

import org.weso.security.types.Cookie;

public interface CookieService {

	public void register( HashMap<String, Object> metadata );

	public Cookie getCookie( String token );

}
