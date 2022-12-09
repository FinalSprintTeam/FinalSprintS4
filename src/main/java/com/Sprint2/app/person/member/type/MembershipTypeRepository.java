package com.Sprint2.app.person.member.type;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  MembershipTypeRepository<T extends MembershipType> extends JpaRepository<T, Long> {
}
