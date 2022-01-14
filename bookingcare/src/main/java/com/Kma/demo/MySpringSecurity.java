package com.Kma.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;



@EnableWebSecurity
@Configuration
public class MySpringSecurity extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers("/member").hasRole("/MEMBER")
			.antMatchers("/admin").hasRole("ADMIN")
		    .anyRequest().permitAll()
		    .and()
		    .formLogin().loginPage("/login").defaultSuccessUrl("/welcome").permitAll()
		    .and()
		    .logout().logoutSuccessUrl("/login").logoutUrl("/logout").permitAll()
		    .and()
		    .exceptionHandling().accessDeniedPage("/access-deny");
	}
}
