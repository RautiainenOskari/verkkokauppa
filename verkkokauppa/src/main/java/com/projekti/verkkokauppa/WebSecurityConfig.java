package com.projekti.verkkokauppa;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.projekti.verkkokauppa.web.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailService;

	private static final AntPathRequestMatcher[] WHITE_LIST_URLS = { 
			new AntPathRequestMatcher("/tuotelistat/**"),
			new AntPathRequestMatcher("/index/**") };
 
	private static final AntPathRequestMatcher[] ADMIN_LIST_URLS = { 
			new AntPathRequestMatcher("/admin/**")};
 

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeRequest -> authorizeRequest
				.requestMatchers(antMatcher("/tuotelistat/**")).permitAll()
				.requestMatchers(antMatcher("/index/**")).permitAll()
				.requestMatchers(WHITE_LIST_URLS).permitAll().requestMatchers(ADMIN_LIST_URLS)
				.hasAuthority("ADMIN")
				.anyRequest().authenticated())
				.headers(headers -> headers
						.frameOptions(frameOptions -> frameOptions.disable())) 
				.formLogin(formlogin -> formlogin
						.defaultSuccessUrl("/index", true).permitAll())
				.logout(logout -> logout.permitAll())
				.csrf(csrf -> csrf.disable());
		return http.build();
	}
 
 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
