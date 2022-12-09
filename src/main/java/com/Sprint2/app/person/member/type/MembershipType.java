package com.Sprint2.app.person.member.type;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Entity
public abstract class MembershipType {
    @Id
    @SequenceGenerator(name = "memtype_sequence", sequenceName = "memtype_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memtype_sequence")
    private Long id;
    private MembershipTypeName name;
    private Double membershipCost;
    private LocalDate startDate;
    private LocalDate endDate;


    public MembershipType(MembershipTypeName name, Double membershipCost, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.membershipCost = membershipCost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MembershipType(LocalDate startDate) {
        this.startDate = startDate;
    }
}
