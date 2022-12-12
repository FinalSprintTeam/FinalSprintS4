package com.Sprint2.app.tournament.scoring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TournamentMemberId implements Serializable {
    private Long tournament;
    private Long member;

}
