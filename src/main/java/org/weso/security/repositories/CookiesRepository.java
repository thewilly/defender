package org.weso.security.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.weso.security.types.Cookie;

@Repository
@EnableScan
public interface CookiesRepository extends CrudRepository<Cookie, String> {

	/**
	 * 
	 * @param token
	 * @return
	 */
	public Cookie findByToken( String token );
}
