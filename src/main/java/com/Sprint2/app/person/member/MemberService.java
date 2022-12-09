package com.Sprint2.app.person.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired MemberRepository memberRepository;

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public Member getMemberByEmail(String email){
        return memberRepository.findByEmail(email);
    }

    public Member getMemberById(Long id){
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Error! Member with ID " + id + " does not exist!"));
    }

    public void addMember(Member member){
        memberRepository.save(member);
    }
}
