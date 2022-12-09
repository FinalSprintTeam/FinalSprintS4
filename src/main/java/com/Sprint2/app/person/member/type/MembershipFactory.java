package com.Sprint2.app.person.member.type;

import java.time.LocalDate;



public class MembershipFactory {

    public static MembershipType createMembership(MembershipTypeName name, LocalDate starDate, Double discount, Integer duration){

        if(name.equals(MembershipTypeName.NORMAL)) {
            return new Normal(starDate);
        } else if(name.equals(MembershipTypeName.TRIAL)){
            return  new Trial(starDate);
        }else if (name.equals(MembershipTypeName.OTHER)){
            return new Other(starDate,discount, duration );
            } else if (name.equals(MembershipTypeName.PREMIUM)) {
            return new Premium(starDate);
        } else{
            return null;
        }
    }

    public static MembershipType createMembership(MembershipTypeName name){
        LocalDate startDate = LocalDate.now();

        if(name.equals(MembershipTypeName.NORMAL)) {
            return new Normal(startDate);
        } else if(name.equals(MembershipTypeName.TRIAL)){
            return  new Trial(startDate);
        }else if (name.equals(MembershipTypeName.PREMIUM)) {
            return new Premium(startDate);
        } else{
            return null;
        }
    }

}
