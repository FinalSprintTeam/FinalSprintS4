package com.Sprint2.app.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository){this.tournamentRepository = tournamentRepository;};

    public List<Tournament> getTournaments() {return tournamentRepository.findAll();}

    public Tournament getTournamentId(Long tournamentid) {
        return tournamentRepository.findById(tournamentid)
                .orElseThrow(() -> new IllegalStateException("Tournament with id " + tournamentid + " does not exist!"));
    }
    public void addTournament(Tournament tournament){tournamentRepository.save(tournament);}
}
