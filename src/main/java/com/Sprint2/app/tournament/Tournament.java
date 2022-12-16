package com.Sprint2.app.tournament;

import com.Sprint2.app.person.member.Member;
import com.Sprint2.app.tournament.scoring.TournamentMember;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tournament")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "location")
    private String location;

    @Column(name = "entry_fee")
    private double entryFee;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TournamentMember> members = new HashSet<>();

    public void addMember(Member member, int score){
        TournamentMember tournamentMember = new TournamentMember(this, member, score);
        this.members.add(tournamentMember);
        member.getTournaments().add(tournamentMember);
    }

    public void removeMember(Member member){
        for (Iterator<TournamentMember> iterator = members.iterator(); iterator.hasNext();){
            TournamentMember tournamentMember = iterator.next();

            if (tournamentMember.getTournament().equals(this) && tournamentMember.getMember().equals(member)){
                iterator.remove();
                tournamentMember.setTournament(null);
                tournamentMember.setMember(null);
            }
        }
    }
}

