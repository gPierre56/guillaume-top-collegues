/**
 * 
 */
package com.diginamic.main.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Guillaume
 *
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Autowired
	JWTAuthorizationFilter jwtAuthorizationFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/h2-console/**").permitAll()
				.antMatchers(HttpMethod.POST, "/auth").permitAll().antMatchers(HttpMethod.GET)
				.hasAnyRole("ROLE_USER", "ROLE_ADMIN").antMatchers(HttpMethod.POST).hasRole("ADMIN").anyRequest()
				.authenticated().and().headers().frameOptions().disable().and()
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class).logout()
				.logoutSuccessHandler((req, resp, auth) -> resp.setStatus(HttpStatus.OK.value()))
				.deleteCookies(TOKEN_COOKIE);
	}

}
