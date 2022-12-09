package com.Sprint2.app.person.member.type;

import java.time.LocalDate;

public class Trial extends MembershipType implements Membershipable{
    private Integer MEMBERSHIPDURATION = 30;

    public Trial(LocalDate startDate) {
        super(startDate);
        super.setName(MembershipTypeName.TRAIL);
        super.setMembershipCost(0.00);
        super.setEndDate(getEndDate(startDate));
    }

    @Override
    public LocalDate getEndDate(LocalDate startDate) {
        return startDate.plusDays(this.MEMBERSHIPDURATION);
    }
}
