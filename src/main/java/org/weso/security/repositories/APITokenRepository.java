package org.weso.security.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.weso.security.types.APIToken;

@Repository
@EnableScan
public interface APITokenRepository extends CrudRepository<APIToken, String> {

	//public List<APIToken> findByToken(String token);
}
