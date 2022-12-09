package com.Sprint2.app.person.member.type;

import jakarta.transaction.Transactional;

@Transactional
public interface NormalRepository extends MembershipTypeRepository<Normal> {
}
