package com.example.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtil {
	private static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	public String generatetoken(String u, String role) {
		return Jwts.builder()
				.setSubject(u)
				.claim("role", role)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+10*60*1000))
				.signWith(key)
				.compact();
	}
	public Claims extractClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public boolean isTokenValid(String token) {
		return !isTokenExpired(extractClaims(token).getExpiration());
	}
	
	private boolean isTokenExpired(Date expi) {
		return expi.before(new Date());
	}

}
