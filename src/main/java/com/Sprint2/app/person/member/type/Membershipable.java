package com.Sprint2.app.person.member.type;

import java.time.LocalDate;

public interface Membershipable {

     Double MEMBERSHIP_COST = 3_000.00;

    LocalDate getEndDate(LocalDate startDate);
}
