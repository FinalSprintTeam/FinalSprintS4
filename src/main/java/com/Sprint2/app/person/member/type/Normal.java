package com.Sprint2.app.person.member.type;

import java.time.LocalDate;

public class Normal extends MembershipType implements Membershipable {
    private Integer MEMBERSHIPDURATION = 365;


    public Normal(LocalDate startDate) {
        super(startDate);
        super.setName(MembershipTypeName.NORMAL);
        super.setMembershipCost(MEMBERSHIP_COST);
        super.setEndDate(getEndDate(startDate));

    }


    @Override
    public LocalDate getEndDate(LocalDate startDate) {
            return startDate.plusDays(this.MEMBERSHIPDURATION);
    }
}
