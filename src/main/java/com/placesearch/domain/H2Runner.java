package com.placesearch.domain;

import com.placesearch.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class H2Runner implements ApplicationRunner {

	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		for (int i = 0; i <= 11; i++) {

			Member member = new Member();
			member.setUid("user" + i);
			member.setUpw("1");
			member.setUpw(passwordEncoder.encode(member.getUpw()));
			member.setUname("user" + i);

			MemberRole role = new MemberRole();
			if (i < 4) {
				role.setRoleName("BASIC");
			} else {
				role.setRoleName("ADMIN");
			}
			member.setRoles(Arrays.asList(role));

			repo.save(member);
		}
  
	}
}
