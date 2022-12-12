package com.Sprint2.app.person.member;

import com.Sprint2.app.person.Person;
import com.Sprint2.app.person.member.type.MembershipType;
import com.Sprint2.app.tournament.Tournament;
import com.Sprint2.app.tournament.scoring.TournamentMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("member")
public class Member extends Person {

    @Column(name = "join_date")
    private LocalDate joinDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="membership_type_id", referencedColumnName = "id")
    private MembershipType membership;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<TournamentMember> tournaments = new HashSet<>();

    public void addTournament(Tournament tournament, int score){
        TournamentMember tournamentMember = new TournamentMember(tournament, this, score);
        this.tournaments.add(tournamentMember);
        tournament.getMembers().add(tournamentMember);
    }
}
