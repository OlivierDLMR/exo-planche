package exo.planche.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfiguration{
	
	@Autowired
	private DataSource datasource;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(datasource)
			.passwordEncoder(null)
			.usersByUsernameQuery("select username, password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
		
	}
	
	public void conigure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/getHello").hasRole("USER")
		.antMatchers(HttpMethod.GET,"/admin/users").hasRole("ADMIN")
		.and()
		.csrf()
		.disable()
		.formLogin()
		.disable();
		

	}
	
	@Bean
	private PasswordEncoder passxordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}