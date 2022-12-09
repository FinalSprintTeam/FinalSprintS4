package com.Sprint2.app.person.member;

import com.Sprint2.app.person.PersonRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MemberRepository extends PersonRepository<Member> {

}
