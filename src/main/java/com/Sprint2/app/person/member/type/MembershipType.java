package com.Sprint2.app.person.member.type;

import jakarta.persistence.*;

@Entity
public abstract class MembershipType {
    @Id
    @SequenceGenerator(name = "memtype_sequence", sequenceName = "memtype_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memtype_sequence")
    private Long id;

}
