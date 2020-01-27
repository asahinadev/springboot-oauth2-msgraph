package com.example.spring.msgraph.json.values;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ConsentProvidedForMinor {
	/** 未設定 */
	NULL,
	/** 同意：有 */
	GRANTED,
	/** 同意：無 */
	DENIED,
	/** 同意：不要 */
	NOT_REQUIRED;

	@JsonValue
	public int toValue() {
		return ordinal();
	}
}
