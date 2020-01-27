package com.example.spring.msgraph.form;

import lombok.Data;

@Data
public class UserForm {

	@Data
	public static class PasswordProfile {
		boolean forceChangePasswordNextSignIn;
		boolean forceChangePasswordNextSignInWithMfa;
		String password;
	}

	String displayName;
	String onPremisesImmutableId;
	String mailNickname;
	String userPrincipalName;
	boolean accountEnabled = true;
	PasswordProfile passwordProfile;
}
