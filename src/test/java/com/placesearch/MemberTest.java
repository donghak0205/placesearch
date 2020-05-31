package com.placesearch;


import com.placesearch.domain.Member;
import com.placesearch.domain.MemberRole;
import com.placesearch.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberRepository repo;

    public MemberTest(MemberRepository repo) {
        this.repo = repo;
    }

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

            //repo
        }

    }
}
