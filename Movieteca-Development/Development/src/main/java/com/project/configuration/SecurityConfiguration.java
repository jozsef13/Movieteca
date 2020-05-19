package com.project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userDetailsService;

	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/images/**", "/fonts/**", "/scss/**").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/movies/**").permitAll()
				.antMatchers("/movie/*").permitAll()
				.antMatchers("/signup").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/addMovie").hasAnyRole("Provider", "Admin")
				.antMatchers("/editmovie.jsp").hasAnyRole("Provider", "Admin")
				.antMatchers("/contact/**").authenticated()
				.antMatchers("/request/**").authenticated()
				.antMatchers("/sendMessage/**").authenticated()
				.antMatchers("/movies/edit").hasAnyRole("Admin")
				.antMatchers("/movie/editPage/**").hasAnyRole("Admin", "Provider")
				.antMatchers("/movie/edit/**").hasAnyRole("Admin", "Provider")
				.antMatchers("/addMoviePage").hasAnyRole("Admin", "Provider")
				.antMatchers("/movie/addReviewPage/**").hasAnyRole("Customer")
				.antMatchers("/movie/addReview/**").hasAnyRole("Customer")
				.antMatchers("/cart/**").hasAnyRole("Customer")
				.antMatchers("/order/**").hasAnyRole("Customer", "Admin")
				.antMatchers("/addToCart/**").hasRole("Customer")
				.antMatchers("/myaccount").authenticated()
				.antMatchers("/user/edit/**").authenticated()
				.antMatchers("/editProfile").authenticated()
				.antMatchers("/user/delete/**").authenticated()
				.antMatchers("/provider/addReviewPage/**").hasAnyRole("Customer")
				.antMatchers("/provider/addReview/**").hasAnyRole("Customer")
				.antMatchers("/user/ban/**").hasAnyRole("Admin")
				.antMatchers("/user/activateAccount/**").hasAnyRole("Admin")
				.and()
					.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/")
					.failureUrl("/login?error=true")
					.permitAll()
				.and()
					.logout()
					.logoutSuccessUrl("/login?logout=true")
					.invalidateHttpSession(true)
					.permitAll()
				.and()
					.exceptionHandling().accessDeniedPage("/forbidden");
	}
}
