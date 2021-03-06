package com.synex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired UserDetailsService userDetailsService;
	
	//@Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	  public void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public
	AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}


	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		//.antMatchers("/*","/*/*","*","/insurance/*","/insurance/plans/*","/home/*").permitAll()
		.antMatchers("/login","/home","/plans","/insurance",
					"/basic/register","/pro/register","/premium/register",
					"/basic/registered","/pro/registered","/premium/registered",
					"/saveUser", "/checkIfExistingUserName","/saveFamilyMember","/setUserAndFamilyMemberRelation","/showUserAndFM","/setFMmedCondition","/saveEnrollmentPlan",
					"/insuranceGatewaysaveEnrollmentPlan","/insuranceGatewaygetEnrollmentPlanByUserId","/insuranceGatewayPaidEnrollmentPlan","/insuranceGatewayUploadFileToClaim",
					"/insuranceGatewaysaveEnrollmentPlan",
					"/images/**","/css/**","/js/**").permitAll()
		.anyRequest().authenticated();
		
		http.formLogin()
		.loginPage("/login")
		//.loginPage("/login")
		.permitAll()
		.defaultSuccessUrl("/success", true)
		.and()
		.exceptionHandling().accessDeniedPage("/accessDeniedPage")
		.and()
		.csrf().disable()
		.httpBasic()
		.and()
		.logout()
		.permitAll();	
	}
	
	//@Override
	public void configure???(WebSecurity web) throws Exception {
		super.configure(web);
		web.ignoring().antMatchers("/images/*", "/css/*", "/js/*");
	}
	
	
}
