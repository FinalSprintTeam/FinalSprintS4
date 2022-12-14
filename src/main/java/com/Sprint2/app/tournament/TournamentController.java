package com.Sprint2.app.tournament;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(path = "api/tournament/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tournament> registerTournament(@RequestBody Tournament tournament){
        return new ResponseEntity<>(tournamentService.addTournament(tournament), HttpStatus.OK) ;
    }

    @PostMapping(path = "api/tournament/addMember")
    public void addMemberToTournament(@RequestParam Long memberId,
                                      @RequestParam Long tournamentId,
                                      @RequestParam int score){
       tournamentService.addMemberToTournament(memberId, tournamentId, score);
    }

    @PutMapping(path = "api/tournament/{id}/edit")
    public void editTournamentDetails(@RequestBody Tournament tournamentToEdit){
        tournamentService.editTournament(tournamentToEdit);
    }
}
