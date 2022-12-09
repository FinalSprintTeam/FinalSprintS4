package com.Sprint2.app.person.member.type;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Transient;

import java.time.LocalDate;

@Entity
@Inheritance
@DiscriminatorValue("other")
public class Other extends MembershipType implements Membershipable{
    @Transient
    private Double discount;
    @Transient
    private Integer duration;


    public Other(LocalDate startDate, Double discount, Integer duration) {
        super(startDate);
        setDiscount(discount);
        setDuration(duration);
        super.setMembershipCost(getMembershipCostDiscount(MEMBERSHIP_COST, discount));
        super.setName(MembershipTypeName.OTHER);
        super.setEndDate(startDate);
    }

    @Override
    public LocalDate getEndDate(LocalDate startDate) {
        return startDate.plusDays(this.duration);
    }

    private Double getMembershipCostDiscount(Double membershipCost, double discount){
        double percent = discount/100;
        return(membershipCost * (1-percent ));
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
