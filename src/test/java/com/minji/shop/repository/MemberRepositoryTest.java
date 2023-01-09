package com.minji.shop.repository;

import com.minji.shop.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;



    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() {
        Member member = new Member();
        member.setUserName("권민지") ;
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
        Assertions.assertThat(findMember).isEqualTo(member);

    }
}