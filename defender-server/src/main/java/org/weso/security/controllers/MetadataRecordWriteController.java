package org.weso.security.controllers;

import org.springframework.http.ResponseEntity;
import org.weso.security.types.MetadataRecord;

public interface MetadataRecordWriteController {
	
	/**
	 * Register.
	 *
	 * @param token the token
	 * @param metadata the metadata
	 */
	public ResponseEntity<String> register( );
	
	/**
	 * Updates the information stored at the token.
	 * 
	 * @param token
	 * @param metadata
	 * @return true if updated, false otherwise.
	 */
	public ResponseEntity<String> update( MetadataRecord record );

}
