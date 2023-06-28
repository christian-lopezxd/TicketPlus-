package com.proyecto.ticketplus.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import com.proyecto.ticketplus.models.entities.Users;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTTools {
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.exptime}")
	private Integer exp;
	
	public String generateToken(Users user) {
		Map<String, Object> claims = new HashMap<>();
		
		return Jwts.builder()
			.addClaims(claims)
			.setSubject(user.getEmail())
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + exp))
			.signWith(Keys.hmacShaKeyFor(secret.getBytes()))
			.compact();
	}
	
	public Boolean verifyToken(String token) {
		try {
			JwtParser parser = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build();
			parser.parse(token);
			return true;
		} catch (IllegalArgumentException e) {
	        System.out.println("Unable to get JWT Token");
	        return false;
	    } catch (ExpiredJwtException e) {
	        System.out.println("JWT TOKEN has expired");
	        return false;
	    } catch (MalformedJwtException e) {
	        System.out.println("JWT Malformado");
	        return false;
	    } catch (Exception e) {
			e.printStackTrace();
			return false;
	    }
	}
	
	public String getUsernameFrom(String token) {
		try {
			JwtParser parser = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build();
			return parser.parseClaimsJws(token).getBody().getSubject();
		} catch (IllegalArgumentException e) {
	        System.out.println("Unable to get JWT Token");
	        return null;
	    } catch (ExpiredJwtException e) {
	        System.out.println("JWT TOKEN has expired");
	        return null;
	    } catch (MalformedJwtException e) {
	        System.out.println("JWT Malformado");
	        return null;
	    } catch (Exception e) {
			e.printStackTrace();
			return null;
	    }
	}
}