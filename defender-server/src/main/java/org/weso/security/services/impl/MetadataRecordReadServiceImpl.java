package org.weso.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weso.security.repositories.MetadataRecordRepository;
import org.weso.security.services.MetadataRecordReadService;
import org.weso.security.types.MetadataRecord;

@Service
public class MetadataRecordReadServiceImpl implements MetadataRecordReadService {
	
	@Autowired
	private MetadataRecordRepository repository;

	@Override
	public MetadataRecord getDataForToken( String token ) {
		return repository.findByToken( token );
	}

}
