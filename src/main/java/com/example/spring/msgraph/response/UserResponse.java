package com.example.spring.msgraph.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

	String id;
	String displayName;

	String surname;
	String givenName;

	String userPrincipalName;

	String aboutMe;
	boolean accountEnabled;
	String ageGroup;
	List<Map<String, Object>> assignedLicenses;
	List<Map<String, Object>> assignedPlans;
	LocalDateTime birthday;
	List<String> businessPhones;
	String city;
	String companyName;
	String consentProvidedForMinor;
	String country;
	LocalDateTime createdDateTime;
	String creationType;
	String department;
	String employeeId;
	String faxNumber;
	LocalDateTime hireDate;
	List<Map<String, Object>> identities;
	List<String> imAddresses;
	List<String> interests;
	boolean isResourceAccount;
	String jobTitle;
	String legalAgeGroupClassification;
	List<Map<String, Object>> licenseAssignmentStates;
	LocalDateTime lastPasswordChangeDateTime;
	String mail;
	Map<String, Object> mailboxSettings;
	String mailNickname;
	String mobilePhone;
	String mySite;
	String officeLocation;
	String onPremisesDistinguishedName;
	String onPremisesDomainName;
	Map<String, Object> onPremisesExtensionAttributes;
	String onPremisesImmutableId;
	LocalDateTime onPremisesLastSyncDateTime;
	List<Map<String, Object>> onPremisesProvisioningErrors;
	String onPremisesSamAccountName;
	String onPremisesSecurityIdentifier;
	boolean onPremisesSyncEnabled;
	String onPremisesUserPrincipalName;
	String otherMails;
	String passwordPolicies;
	Map<String, Object> passwordProfile;
	List<String> pastProjects;
	String postalCode;
	String preferredDataLocation;
	String preferredLanguage;
	String preferredName;
	List<Map<String, Object>> provisionedPlans;
	List<String> proxyAddresses;
	List<String> responsibilities;
	List<String> schools;
	boolean showInAddressList;
	LocalDateTime signInSessionsValidFromDateTime;
	List<String> skills;
	String state;
	String streetAddress;
	String usageLocation;
	String userType;
	Map<String, Object> calendar;
	List<Map<String, Object>> calendarGroups;
	List<Map<String, Object>> calendarView;
	List<Map<String, Object>> calendars;
	List<Map<String, Object>> contacts;
	List<Map<String, Object>> contactFolders;
	List<Map<String, Object>> createdObjects;
	List<Map<String, Object>> directReports;
	Map<String, Object> drive;
	List<Map<String, Object>> drives;
	List<Map<String, Object>> events;
	Map<String, Object> inferenceClassification;
	List<Map<String, Object>> mailFolders;
	Map<String, Object> manager;
	List<Map<String, Object>> memberOf;
	List<Map<String, Object>> messages;
	Map<String, Object> outlook;
	List<Map<String, Object>> ownedDevices;
	List<Map<String, Object>> ownedObjects;
	Map<String, Object> photo;
	List<Map<String, Object>> registeredDevices;

	@JsonAnySetter
	Map<String, Object> ext;
}
