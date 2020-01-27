package com.example.spring.msgraph.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				// webjars
				"/webjars/**",
				// CSS ファイル
				"/css/**",
				// JavaScriptファイル
				"/js/**",
				// 画像ファイル
				"/img/**",
				// サウンドファイル
				"/sound/**",
				// WEB フォント
				"/font*/**",
				// 外部ライブラリ
				"/exlib/**"
		/**/
		);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// TOP画面 は認証不要
				.antMatchers("/").permitAll()
				// その他画面 は認証必要
				.anyRequest().authenticated();

		// ログアウト設定
		http.logout();

		// FORM ログイン設定
		http.formLogin().disable();

		// BASIC ログイン設定
		http.httpBasic().disable();

		// Cross Site Request Forgeries 設定
		http.csrf().disable();

		// Cross-Origin Resource 設定
		http.cors().disable();

		// OAUTH2 / OID 認証
		http.oauth2Login()

				// 認証エンドポイント
				.authorizationEndpoint().and()

				// リダイレクトエンドポイント
				.redirectionEndpoint().and()

				// アクセストークンエンドポイント
				.tokenEndpoint().and()

				// ユーザー情報エンドポイント
				.userInfoEndpoint().and()

		;

	}

}
