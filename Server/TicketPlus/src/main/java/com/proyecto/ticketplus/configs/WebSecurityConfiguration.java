package com.proyecto.ticketplus.configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import static org.springframework.security.config.Customizer.withDefaults;

import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.services.IUsersService;
import com.proyecto.ticketplus.utils.JWTTokenFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsersService userService;
	
	@Autowired
	private JWTTokenFilter filter;
	
	@Bean
	AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
	    AuthenticationManagerBuilder managerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
	    
	    managerBuilder.userDetailsService(identifier -> {
	    		Users user = userService.findOneByEmail(identifier);
	    		
	    		if(user == null) {
	    			throw new UsernameNotFoundException("User: " + identifier + ", not found!");
	    		}
	    		
	    		return user;
	    	}).passwordEncoder(passwordEncoder);
	    
	    return managerBuilder.build();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Enabling CORS
        http.httpBasic(Customizer.withDefaults()).cors(c -> c.configurationSource(request -> {
            final CorsConfiguration cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("*"));
            cors.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "HEAD", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("Origin", "Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization"));
            cors.setExposedHeaders(List.of("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Authorization"));
            return cors;
        }));
		
		//Http login and cors disabled
		 http.httpBasic(withDefaults()).csrf(csrf -> csrf.disable());
	    
	    //Route filter
	    http.authorizeHttpRequests(auth -> 
	    	auth.requestMatchers("/auth/**").permitAll().anyRequest().authenticated()
	    );
	    
	    //Statelessness
	    http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	    
	    //UnAunthorized handler
	    http.exceptionHandling(handling -> handling.authenticationEntryPoint((req, res, ex) -> {
	        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Auth fail!");
	    }));
	    
	    //JWT filter
	    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}