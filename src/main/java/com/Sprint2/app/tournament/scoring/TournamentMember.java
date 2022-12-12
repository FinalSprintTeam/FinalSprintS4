package com.Sprint2.app.tournament.scoring;

import com.Sprint2.app.person.member.Member;
import com.Sprint2.app.tournament.Tournament;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tournament_member")
@IdClass(TournamentMemberId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TournamentMember implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    @JsonIgnore
    private Tournament tournament;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnoreProperties(value = { "joinDate", "membership", "tournaments",  "address", "email"})
    private Member member;

    @Column(name = "score")
    private int score;
}
