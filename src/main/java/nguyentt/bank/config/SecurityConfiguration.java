package nguyentt.bank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	// authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("rac")
			.password("secret")
			.roles("USER", "ADMIN");
	}
	
	// Authorization
	
	public void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests()
			.anyRequest().hasRole("USER")
			.and()
			.formLogin()
			.loginProcessingUrl("/login").permitAll();
	}
}
