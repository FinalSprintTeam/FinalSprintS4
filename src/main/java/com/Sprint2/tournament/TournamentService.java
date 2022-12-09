package com.Sprint2.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository){this.tournamentRepository = tournamentRepository;};

    public List<Tournament> getTournaments() {return tournamentRepository.findAll();}

    public Tournament getTournamentId(Long tournamentid) throws Exception {
        return tournamentRepository.findById(Long tournamentid);
        throw new Exception("Tournament " + tournamentid + " does not exist!");
    }
    public void addTournament(Tournament tournament){tournamentRepository.save(tournament);}
}
