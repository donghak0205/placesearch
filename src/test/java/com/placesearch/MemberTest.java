package com.placesearch;


import com.placesearch.domain.Member;
import com.placesearch.domain.MemberRole;
import com.placesearch.repository.MemberRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
@Log
public class MemberTest {

    @Autowired
    private MemberRepository repo;

    @Test
    public void testInsert(){

        for(int i=0; i<=10; i++){
            Member member = new Member();
            member.setUid("user" + i);
            member.setUpw("pw" + i);
            member.setUname("사용자" + i);

            MemberRole memberRole = new MemberRole();
            if(i<5){
                memberRole.setRoleName("BASIC");
            } else {
                memberRole.setRoleName("ADMIN");
            }

            member.setRoles(Arrays.asList(memberRole));

            repo.save(member);
        }

    }

    @Test
    public void testRead(){

        Optional<Member> result = repo.findById("user01");

        result.ifPresent(member -> log.info("member" + member));
    }
}
