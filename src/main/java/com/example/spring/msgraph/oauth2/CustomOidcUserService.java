package com.example.spring.msgraph.oauth2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class CustomOidcUserService
		implements OAuth2UserService<OidcUserRequest, OidcUser> {

	private static final String INVALID_USER_INFO_RESPONSE_ERROR_CODE = "invalid_user_info_response";
	private final Set<String> userInfoScopes = new HashSet<>(
			Arrays.asList(
					OidcScopes.PROFILE,
					OidcScopes.EMAIL,
					OidcScopes.ADDRESS,
					OidcScopes.PHONE));
	private OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService = new DefaultOAuth2UserService();

	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		Assert.notNull(userRequest, "userRequest cannot be null");
		OidcUserInfo userInfo = null;
		String userNameAttributeName = userRequest.getClientRegistration()
				.getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

		if (StringUtils.isEmpty(userNameAttributeName)) {
			userNameAttributeName = StandardClaimNames.SUB;
		}

		OAuth2User oauth2User = this.oauth2UserService.loadUser(userRequest);
		userInfo = new OidcUserInfo(oauth2User.getAttributes());

		if (Objects.equals(userRequest.getClientRegistration().getRegistrationId(), "msgraph")) {
			// msgraph の実行時は idToken の整合性をチェックしない
		} else if (this.shouldRetrieveUserInfo(userRequest)) {
			// https://openid.net/specs/openid-connect-core-1_0.html#UserInfoResponse

			// 1) The sub (subject) Claim MUST always be returned in the UserInfo Response
			String subject = userInfo.getSubject();
			if (subject == null) {
				OAuth2Error oauth2Error = new OAuth2Error(INVALID_USER_INFO_RESPONSE_ERROR_CODE);
				throw new OAuth2AuthenticationException(oauth2Error, oauth2Error.toString());
			}

			// 2) Due to the possibility of token substitution attacks (see Section 16.11),
			// the UserInfo Response is not guaranteed to be about the End-User
			// identified by the sub (subject) element of the ID Token.
			// The sub Claim in the UserInfo Response MUST be verified to exactly match
			// the sub Claim in the ID Token; if they do not match,
			// the UserInfo Response values MUST NOT be used.
			String idTokenSubject = userRequest.getIdToken().getSubject();
			if (!Objects.equals(idTokenSubject, subject)) {
				OAuth2Error oauth2Error = new OAuth2Error(INVALID_USER_INFO_RESPONSE_ERROR_CODE);
				throw new OAuth2AuthenticationException(oauth2Error, oauth2Error.toString());
			}
		}

		Set<GrantedAuthority> authorities = Collections.singleton(
				new OidcUserAuthority(userRequest.getIdToken(), userInfo));

		OidcUser user;

		if (StringUtils.hasText(userNameAttributeName)) {
			user = new DefaultOidcUser(authorities, userRequest.getIdToken(), userInfo, userNameAttributeName);
		} else {
			user = new DefaultOidcUser(authorities, userRequest.getIdToken(), userInfo);
		}

		return user;
	}

	private boolean shouldRetrieveUserInfo(OidcUserRequest userRequest) {
		// Auto-disabled if UserInfo Endpoint URI is not provided
		if (StringUtils.isEmpty(userRequest.getClientRegistration().getProviderDetails()
				.getUserInfoEndpoint().getUri())) {

			return false;
		}

		// The Claims requested by the profile, email, address, and phone scope values
		// are returned from the UserInfo Endpoint (as described in Section 5.3.2),
		// when a response_type value is used that results in an Access Token being issued.
		// However, when no Access Token is issued, which is the case for the response_type=id_token,
		// the resulting Claims are returned in the ID Token.
		// The Authorization Code Grant Flow, which is response_type=code, results in an Access Token being issued.
		if (AuthorizationGrantType.AUTHORIZATION_CODE.equals(
				userRequest.getClientRegistration().getAuthorizationGrantType())) {

			// Return true if there is at least one match between the authorized scope(s) and UserInfo scope(s)
			return CollectionUtils.containsAny(userRequest.getAccessToken().getScopes(), this.userInfoScopes);
		}

		return false;
	}

	/**
	 * Sets the {@link OAuth2UserService} used when requesting the user info
	 * resource.
	 *
	 * @since 5.1
	 * @param oauth2UserService the {@link OAuth2UserService} used when
	 *                          requesting the user info resource.
	 */
	public final void setOauth2UserService(OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService) {
		Assert.notNull(oauth2UserService, "oauth2UserService cannot be null");
		this.oauth2UserService = oauth2UserService;
	}

}
