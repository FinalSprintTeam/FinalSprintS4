package com.Sprint2.app.person.member.type;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Inheritance
@DiscriminatorValue("premium")
@NoArgsConstructor
public class Premium extends MembershipType implements Membershipable {

    @Transient
    private Integer MEMBERSHIPDURATION = 365;

    public Premium(LocalDate startDate) {
        super(startDate);
        super.setName("Premium");
        super.setMembershipCost(MEMBERSHIP_COST * 1.50);
        super.setEndDate(getEndDate(startDate));
    }

    @Override
    public LocalDate getEndDate(LocalDate startDate) {
        return startDate.plusDays(this.MEMBERSHIPDURATION);
    }
}
