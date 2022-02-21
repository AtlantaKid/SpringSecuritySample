package com.accu.SpringSecuritySample.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jdbcUserDetailsManager()).passwordEncoder(passwordEncoder());
	}

	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);

		return jdbcUserDetailsManager;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// @formatter:off
  @Override
  protected void configure(HttpSecurity http) throws Exception {
 
  	/*
  	 * uncomment the line below to stop the exposer. 
  	 */
//  	http.authorizeRequests().antMatchers("/users", "/users/", "/groups", "/groups/", "/profile", "/profile/").denyAll();
  	
  	http.authorizeRequests()
  		.antMatchers("/**", "/h2-console/**").permitAll() // (3) 
  		.anyRequest().authenticated() // (4)
  		.and()
  		.formLogin() // (5)
  		//.loginPage("/login") // (5)
  		.permitAll()
  		.and()
  		.logout() // (6)
  		.permitAll()
  		.and()
  		.httpBasic(); // (7)
  	
  	
  	http.csrf().disable();
    http.headers().frameOptions().disable();
    
  } // end of configure
  
}