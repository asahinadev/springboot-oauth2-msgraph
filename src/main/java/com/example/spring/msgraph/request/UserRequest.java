package com.example.spring.msgraph.request;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
	
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	static class PasswordProfile {
		boolean forceChangePasswordNextSignIn = false;
		boolean forceChangePasswordNextSignInWithMfa = false;
		String password;
	}

	String aboutMe;
	boolean accountEnabled;
	LocalDateTime birthday;
	List<String> businessPhones;
	String city;
	String country;
	String department;
	String displayName;
	String givenName;
	LocalDateTime hireDate;
	List<String> interests;
	String jobTitle;
	String mailNickname;
	String mobilePhone;
	String mySite;
	String officeLocation;
	String onPremisesImmutableId;
	String otherMails;
	String passwordPolicies;
	PasswordProfile passwordProfile;
	List<String> pastProjects;
	String postalCode;
	String preferredLanguage;
	List<String> responsibilities;
	List<String> schools;
	List<String> skills;
	String state;
	String streetAddress;
	String surname;
	String usageLocation;
	String userPrincipalName;
	String userType;

}
