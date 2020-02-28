package com.example.spring.msgraph.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class UserResponse {

	String id;
	String displayName;
	String surname;
	String givenName;
	String userPrincipalName;
	String preferredLanguage;
	String mail;
	String officeLocation;
	List<String> businessPhones = new ArrayList<>();
	String mobilePhone;
	String jobTitle;

	@JsonProperty("@odata.context")
	String odata_context;

	//	String aboutMe;
	//	boolean accountEnabled;
	//	String ageGroup;
	//	List<Map<String, Object>> assignedLicenses = new ArrayList<>();
	//	List<Map<String, Object>> assignedPlans = new ArrayList<>();
	//	LocalDateTime birthday;
	//	String city;
	//	String companyName;
	//	String consentProvidedForMinor;
	//	String country;
	//	LocalDateTime createdDateTime;
	//	String creationType;
	//	String department;
	//	String employeeId;
	//	String faxNumber;
	//	LocalDateTime hireDate;
	//	List<Map<String, Object>> identities = new ArrayList<>();
	//	List<String> imAddresses = new ArrayList<>();
	//	List<String> interests = new ArrayList<>();
	//	boolean isResourceAccount;
	//	String legalAgeGroupClassification;
	//	List<Map<String, Object>> licenseAssignmentStates = new ArrayList<>();
	//	LocalDateTime lastPasswordChangeDateTime;
	//	Map<String, Object> mailboxSettings = new HashMap<>();
	//	String mailNickname;
	//	String mySite;
	//	String onPremisesDistinguishedName;
	//	String onPremisesDomainName;
	//	Map<String, Object> onPremisesExtensionAttributes = new HashMap<>();
	//	String onPremisesImmutableId;
	//	LocalDateTime onPremisesLastSyncDateTime;
	//	List<Map<String, Object>> onPremisesProvisioningErrors = new ArrayList<>();
	//	String onPremisesSamAccountName;
	//	String onPremisesSecurityIdentifier;
	//	boolean onPremisesSyncEnabled;
	//	String onPremisesUserPrincipalName;
	//	String otherMails;
	//	String passwordPolicies;
	//	Map<String, Object> passwordProfile = new HashMap<>();
	//	List<String> pastProjects = new ArrayList<>();
	//	String postalCode;
	//	String preferredDataLocation;
	//	String preferredName;
	//	List<Map<String, Object>> provisionedPlans;
	//	List<String> proxyAddresses = new ArrayList<>();
	//	List<String> responsibilities = new ArrayList<>();
	//	List<String> schools = new ArrayList<>();
	//	boolean showInAddressList;
	//	LocalDateTime signInSessionsValidFromDateTime;
	//	List<String> skills = new ArrayList<>();
	//	String state;
	//	String streetAddress;
	//	String usageLocation;
	//	String userType;
	//	Map<String, Object> calendar = new HashMap<>();
	//	List<Map<String, Object>> calendarGroups = new ArrayList<>();
	//	List<Map<String, Object>> calendarView = new ArrayList<>();
	//	List<Map<String, Object>> calendars = new ArrayList<>();
	//	List<Map<String, Object>> contacts = new ArrayList<>();
	//	List<Map<String, Object>> contactFolders = new ArrayList<>();
	//	List<Map<String, Object>> createdObjects = new ArrayList<>();
	//	List<Map<String, Object>> directReports = new ArrayList<>();
	//	Map<String, Object> drive = new HashMap<>();
	//	List<Map<String, Object>> drives = new ArrayList<>();
	//	List<Map<String, Object>> events = new ArrayList<>();
	//	Map<String, Object> inferenceClassification;
	//	List<Map<String, Object>> mailFolders = new ArrayList<>();
	//	Map<String, Object> manager = new HashMap<>();
	//	List<Map<String, Object>> memberOf = new ArrayList<>();
	//	List<Map<String, Object>> messages = new ArrayList<>();
	//	Map<String, Object> outlook = new HashMap<>();
	//	List<Map<String, Object>> ownedDevices = new ArrayList<>();
	//	List<Map<String, Object>> ownedObjects = new ArrayList<>();
	//	Map<String, Object> photo = new HashMap<>();
	//	List<Map<String, Object>> registeredDevices = new ArrayList<>();

	@JsonAnySetter
	Map<String, Object> ext = new HashMap<>();
}
