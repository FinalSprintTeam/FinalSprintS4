package com.Sprint2.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TournamentController {
   @Autowired TournamentService tournamentService;

   @GetMapping(path = "api/tournament/all")
    public List<Tournament> getTournaments(){return tournamentService.getTournaments();}

    @GetMapping(path = "api/tournament/{tournamentID}")
    public Tournament findById(@PathVariable("tournamentID") Long tournamentID ){
        try {
            return tournamentService.getTournamentId(tournamentID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
