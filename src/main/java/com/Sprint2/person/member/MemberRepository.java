package com.Sprint2.person.member;

import com.Sprint2.person.PersonRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MemberRepository extends PersonRepository<Member> {

}
