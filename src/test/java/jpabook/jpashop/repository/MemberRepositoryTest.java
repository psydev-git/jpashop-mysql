package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    public void testMember() throws Exception {

        //given
        Member member = new Member();
        member.setName("memberA");
            memberRepository.save(member);

    }




}