package org.weso.security.defender.server.controllers;

import org.springframework.http.ResponseEntity;
import org.weso.security.defender.server.types.MetadataEntry;

public interface MetadataEntryWriteController {
	
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
	public ResponseEntity<String> update( MetadataEntry record );

}
