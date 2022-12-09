package com.Sprint2.app.person.member;

import com.Sprint2.app.person.address.Address;
import com.Sprint2.app.person.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired MemberRepository memberRepository;
    @Autowired AddressRepository addressRepository;

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

    public void addMember(Member member, Long addressID){
        Address address = addressRepository.findById(addressID)
                .orElseThrow(() -> new IllegalStateException("Invalid address ID!"));;

        member.setAddress(address);
        memberRepository.save(member);
    }
}
