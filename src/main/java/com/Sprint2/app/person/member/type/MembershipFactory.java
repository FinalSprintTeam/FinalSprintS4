package com.Sprint2.app.person.member.type;

import java.time.LocalDate;



public class MembershipFactory {

    public static MembershipType createMembership(MembershipTypeName name, LocalDate starDate, Double discount, Integer duration){

    if(name.equals(MembershipTypeName.NORMAL)) {
        return new Normal(starDate);
    } else if(name.equals(MembershipTypeName.TRAIL)){
        return  new Trial(starDate);
    }else if (name.equals(MembershipTypeName.OTHER)){
        return new Other(starDate,discount, duration );
        }else{
        return null;
    }
}

}
