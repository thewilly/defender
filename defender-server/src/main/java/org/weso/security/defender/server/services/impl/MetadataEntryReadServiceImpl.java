package org.weso.security.defender.server.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weso.security.defender.server.repositories.MetadataEntryRepository;
import org.weso.security.defender.server.services.MetadataEntryReadService;
import org.weso.security.defender.server.types.MetadataEntry;

@Service
public class MetadataEntryReadServiceImpl implements MetadataEntryReadService {
	
	@Autowired
	private MetadataEntryRepository repository;

	@Override
	public MetadataEntry getDataForToken( String token ) {
		return repository.findByToken( token );
	}

}
