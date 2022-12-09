package com.Sprint2.app.person.member;

import com.Sprint2.app.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("Member")
public class Member extends Person {

    @Column(name = "join_date")
    private LocalDate joinDate;


}
