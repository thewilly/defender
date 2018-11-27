package org.weso.security.defender.server.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.weso.security.defender.server.types.MetadataEntry;

@Repository
public interface MetadataEntryRepository extends MongoRepository<MetadataEntry, ObjectId> {
	
	MetadataEntry findByToken( String token );

}
