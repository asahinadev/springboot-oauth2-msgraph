package com.example.spring.msgraph.json.values;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AgeGroup {
	/** 未設定 */
	NULL,
	/** 未成年（保護者同意：無） */
	MINOR_WITHOUT_PARENTAL_CONSENT,
	/** 未成年（保護者同意：有） */
	MINOR_WITH_PARENTAL_CONSENT,
	/** 成年 */
	ADULT,
	/** 未成年 */
	NOT_ADULT,
	/** 未成年（法規：無） */
	MINOR_NO_PARENTAL_CONSENT_REQUIRED;

	@JsonValue
	public int toValue() {
		return ordinal();
	}
}
