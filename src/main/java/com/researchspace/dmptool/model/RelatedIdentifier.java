package com.researchspace.dmptool.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The structure of this class is dictated by the request body of the
 * related_identifiers endpoint; for documentation, see
 * https://github.com/CDLUC3/dmptool/wiki/API-Edit-DMP#adding-related-identifiers-publications-datasets-etc-to-a-dmp
 */
@Data
@AllArgsConstructor
public class RelatedIdentifier {

	// Some of these should probably be enums
	public String descriptor;
	public String work_type;
	public String type;
	public String identifier;

}

