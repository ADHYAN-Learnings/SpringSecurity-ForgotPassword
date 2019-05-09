package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
public class SpringSecurityImplementation extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SpringSecurityUserDetailsService springSecurityUserDetailsService;
	
	@Bean
	public static  PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {  //@formatter:off
		final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(springSecurityUserDetailsService);
		authentication.authenticationProvider(authenticationProvider);
	} // @formatter:on
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
	
		http
		   .authorizeRequests()
		    .antMatchers("/signup","/saveRegistration","/registrationConfirmation","/forgotPassword",
		    		"/resetPassword","/changeSavePassword","/changePassword").permitAll()
		    .anyRequest().authenticated()
		   .and()
		   .formLogin()
		    .loginPage("/login").permitAll()
		    .loginProcessingUrl("/loginSubmit")
		    .and()
		    .logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logoutSubmit","GET"))
		    .and()
		    .csrf().disable(); 
		
	} 

}
