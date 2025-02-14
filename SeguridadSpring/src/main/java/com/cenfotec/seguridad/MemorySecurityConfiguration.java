package com.cenfotec.seguridad;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MemorySecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		String encodedPassword = new BCryptPasswordEncoder().encode("javier");
		auth.inMemoryAuthentication().withUser("javier").password(encodedPassword).roles("manager", "dev").and().passwordEncoder(new BCryptPasswordEncoder());
		}
}
