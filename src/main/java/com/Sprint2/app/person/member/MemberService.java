package com.Sprint2.app.person.member;

import com.Sprint2.app.person.address.Address;
import com.Sprint2.app.person.address.AddressRepository;
import com.Sprint2.app.person.member.type.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Member addMember(Member member, Long addressID, String typeName){
        MembershipTypeName membership = MembershipTypeName.NORMAL;
        Address address = addressRepository.findById(addressID)
                .orElseThrow(() -> new IllegalStateException("Invalid address ID!"));

        switch (typeName) {
            case "Premium" -> membership = MembershipTypeName.PREMIUM;
            case "Trial" -> membership = MembershipTypeName.TRIAL;
        }
        MembershipType membershipType = MembershipFactory.createMembership(membership);

        member.setAddress(address);
        member.setMembership(membershipType);
        return memberRepository.save(member);
    }

    @Transactional
    public Member editMember(Member member, Long addressID, String typeName){
        Member memberToEdit = memberRepository.findById(member.getId())
                .orElseThrow(() -> new IllegalStateException("Error! Member with ID " + member.getId() + " does not exist!"));

        Address address = addressRepository.findById(addressID)
                .orElseThrow(() -> new IllegalStateException("Invalid address ID!"));

        memberToEdit.setFirstName(member.getFirstName());
        memberToEdit.setLastName(member.getLastName());
        memberToEdit.setEmail(member.getEmail());
        memberToEdit.setJoinDate(member.getJoinDate());

        memberToEdit.setAddress(address);

        if (!memberToEdit.getMembership().getName().equals(typeName)){
            MembershipTypeName membership = MembershipTypeName.NORMAL;
            switch (typeName) {
                case "Premium" -> membership = MembershipTypeName.PREMIUM;
                case "Trial" -> membership = MembershipTypeName.TRIAL;
            }
            MembershipType membershipType = MembershipFactory.createMembership(membership);
            memberToEdit.setMembership(membershipType);
        }

        return memberToEdit;
    }

    public void deleteTournament(Long memberId){
        boolean exists = memberRepository.existsById(memberId);
        if (!exists) throw new IllegalStateException("Error! Tournament with ID " + memberId + " does not exist!");
        else memberRepository.deleteById(memberId);
    }
}
