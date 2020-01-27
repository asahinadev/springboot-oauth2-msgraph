package com.example.spring.msgraph.json;

import java.util.Map;
import java.util.Set;

import com.example.spring.msgraph.json.values.AgeGroup;
import com.example.spring.msgraph.json.values.ConsentProvidedForMinor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	@JsonProperty
	String aboutMe;
	@JsonProperty
	boolean accountEnabled;
	@JsonProperty
	AgeGroup ageGroup = AgeGroup.NULL;
	@JsonProperty
	Set<Map<String, String>> assignedLicenses;
	@JsonProperty
	Set<Map<String, String>> assignedPlans;
	@JsonProperty
	String birthday;
	@JsonProperty
	Set<String> businessPhones;
	@JsonProperty
	String city;
	@JsonProperty
	String companyName;
	@JsonProperty
	ConsentProvidedForMinor consentProvidedForMinor = ConsentProvidedForMinor.NULL;
	@JsonProperty
	String country;
	@JsonProperty
	String createdDateTime;
	@JsonProperty
	String creationType;
	@JsonProperty
	String department;
	@JsonProperty
	String displayName;
	@JsonProperty
	String employeeId;
	@JsonProperty
	String faxNumber;
	@JsonProperty
	String givenName;
	@JsonProperty
	String hireDate;
	@JsonProperty
	String id;
	@JsonProperty
	Set<Map<String, String>> identities;
	@JsonProperty
	Set<String> imAddresses;
	@JsonProperty
	Set<String> interests;
	@JsonProperty
	boolean isResourceAccount;
	@JsonProperty
	String jobTitle;
	@JsonProperty
	String legalAgeGroupClassification;
	@JsonProperty
	Set<Map<String, String>> licenseAssignmentStates;
	@JsonProperty
	String lastPasswordChangeDateTime;
	@JsonProperty
	String mail;
	@JsonProperty
	Map<String, String> mailboxSettings;
	@JsonProperty
	String mailNickname;
	@JsonProperty
	String mobilePhone;
	@JsonProperty
	String mySite;
	@JsonProperty
	String officeLocation;
	@JsonProperty
	String onPremisesDistinguishedName;
	@JsonProperty
	String onPremisesDomainName;
	@JsonProperty
	Map<String, String> onPremisesExtensionAttributes;
	@JsonProperty
	String onPremisesImmutableId;
	@JsonProperty
	String onPremisesLastSyncDateTime;
	@JsonProperty
	Set<Map<String, String>> onPremisesProvisioningErrors;
	@JsonProperty
	String onPremisesSamAccountName;
	@JsonProperty
	String onPremisesSecurityIdentifier;
	@JsonProperty
	boolean onPremisesSyncEnabled;
	@JsonProperty
	String onPremisesUserPrincipalName;
	@JsonProperty
	String otherMails;
	@JsonProperty
	String passwordPolicies;
	@JsonProperty
	Set<Map<String, String>> passwordProfile;
	@JsonProperty
	Set<String> pastProjects;
	@JsonProperty
	String postalCode;
	@JsonProperty
	String preferredDataLocation;
	@JsonProperty
	String preferredLanguage;
	@JsonProperty
	String preferredName;
	@JsonProperty
	Set<Map<String, String>> provisionedPlans;
	@JsonProperty
	Set<String> proxyAddresses;
	@JsonProperty
	Set<String> responsibilities;
	@JsonProperty
	Set<String> schools;
	@JsonProperty
	boolean showInAddressList;
	@JsonProperty
	String signInSessionsValidFromDateTime;
	@JsonProperty
	Set<String> skills;
	@JsonProperty
	String state;
	@JsonProperty
	String streetAddress;
	@JsonProperty
	String surname;
	@JsonProperty
	String usageLocation;
	@JsonProperty
	String userPrincipalName;
	@JsonProperty
	String userType;
	@JsonProperty
	Map<String, String> calendar;
	@JsonProperty
	Set<Map<String, String>> calendarGroups;
	@JsonProperty
	Set<Map<String, String>> calendarView;
	@JsonProperty
	Set<Map<String, String>> calendars;
	@JsonProperty
	Set<Map<String, String>> contacts;
	@JsonProperty
	Set<Map<String, String>> contactFolders;
	@JsonProperty
	Set<Map<String, String>> createdObjects;
	@JsonProperty
	Set<Map<String, String>> directReports;
	@JsonProperty
	Map<String, String> drive;
	@JsonProperty
	Set<Map<String, String>> drives;
	@JsonProperty
	Set<Map<String, String>> events;
	@JsonProperty
	Map<String, String> inferenceClassification;
	@JsonProperty
	Set<Map<String, String>> mailFolders;
	@JsonProperty
	Map<String, String> manager;
	@JsonProperty
	Set<Map<String, String>> memberOf;
	@JsonProperty
	Set<Map<String, String>> messages;
	@JsonProperty
	Map<String, String> outlook;
	@JsonProperty
	Set<Map<String, String>> ownedDevices;
	@JsonProperty
	Set<Map<String, String>> ownedObjects;
	@JsonProperty
	Map<String, String> photo;
	@JsonProperty
	Set<Map<String, String>> registered;

}
