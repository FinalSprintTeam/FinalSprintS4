package com.Sprint2.app.person.member.type;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Inheritance
@DiscriminatorValue("normal")
@NoArgsConstructor
public class Normal extends MembershipType implements Membershipable {
    @Transient
    private Integer MEMBERSHIPDURATION = 365;


    public Normal(LocalDate startDate) {
        super(startDate);
        super.setName("Normal");
        super.setMembershipCost(MEMBERSHIP_COST);
        super.setEndDate(getEndDate(startDate));

    }


    @Override
    public LocalDate getEndDate(LocalDate startDate) {
            return startDate.plusDays(this.MEMBERSHIPDURATION);
    }
}
