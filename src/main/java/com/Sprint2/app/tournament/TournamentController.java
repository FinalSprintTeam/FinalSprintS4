package com.Sprint2.app.tournament;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TournamentController {
    @Autowired TournamentService tournamentService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping(path = "api/tournament/all")
    public List<Tournament> getTournaments(){return tournamentService.getTournaments();}

    @GetMapping(path = "api/tournament/{tournamentID}")
    public Tournament findById(@PathVariable("tournamentID") Long tournamentID ){
        try {
            return tournamentService.getTournamentById(tournamentID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(path = "api/tournament/new")
    public void registerTournament(@RequestBody Tournament tournament){
        tournamentService.addTournament(tournament);
    }

    @PostMapping(path = "api/tournament/addMember")
    public void addMemberToTournament(@RequestParam Long memberId,
                                      @RequestParam Long tournamentId,
                                      @RequestParam int score){
       tournamentService.addMemberToTournament(memberId, tournamentId, score);
    }
}
