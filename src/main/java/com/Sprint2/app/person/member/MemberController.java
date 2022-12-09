package com.Sprint2.app.person.member;

import com.Sprint2.app.person.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired MemberService memberService;

    @GetMapping(path = "api/member/all")
    public List<Member> getMembers(){
        return memberService.getMembers();
    }

    @GetMapping(path = "api/member")
    public Member findByEmail(@RequestParam String email){
        return memberService.getMemberByEmail(email);
    }

    @GetMapping(path = "api/member/{id}")
    public Member findById(@PathVariable("id") Long id){
        return memberService.getMemberById(id);
    }

    @PostMapping(path = "api/member/new")
    public void registerMember(@RequestBody Member member, @RequestParam Long addressID){
        memberService.addMember(member, addressID);
    }

}
