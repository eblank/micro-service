package com.example.gateway.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

import javax.annotation.Resource;

/**
 * @author luxp
 * @date 2018/12/20
 */
@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource
	private OAuth2ClientContext oauth2ClientContext;
	@Resource
	private OAuth2ProtectedResourceDetails details;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().mvcMatchers("/favicon.ico", "/static/**", "/auth-center/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.logout().logoutSuccessUrl("/")
				.and()
				.csrf().disable();
	}

	@Bean
	public OAuth2RestTemplate oauth2RestTemplate() {
		return new OAuth2RestTemplate(details, oauth2ClientContext);
	}
}
