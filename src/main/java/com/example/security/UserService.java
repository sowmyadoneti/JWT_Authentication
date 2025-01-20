package com.example.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	JwtUtil jwtUtil;
	private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	
	public String loginu(String u, String p) {
		Optional<Userentity>  userOpt= userRepo.findByUsername(u);
		if (userOpt.isPresent() && passwordEncoder.matches(p, userOpt.get().getPassword())) {
            return jwtUtil.generatetoken(u, userOpt.get().getRole());
        }
		throw new RuntimeException("Invalid username or password");
	}

	public void registeru(String u, String p, String r) {
		Userentity us=new Userentity();
		us.setUsername(u);
		us.setPassword(passwordEncoder.encode(p));
		us.setRole(r);
		userRepo.save(us);
		
	}

}
