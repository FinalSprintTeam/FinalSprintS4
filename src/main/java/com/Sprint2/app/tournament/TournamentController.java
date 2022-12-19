package com.Sprint2.app.tournament;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://semester4-sprint2-website.s3-website-us-east-1.amazonaws.com/", "http://localhost:3000/"})
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

    @PostMapping(path = "api/tournament/addMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tournament> addMemberToTournament(@RequestParam Long memberId,
                                      @RequestParam Long tournamentId,
                                      @RequestParam int score){
       return new ResponseEntity<>(tournamentService.addMemberToTournament(memberId, tournamentId, score), HttpStatus.OK);
    }

    @PostMapping(path = "api/tournament/removeMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tournament> removeMemberFromTournament(@RequestParam Long memberId,
                                                            @RequestParam Long tournamentId){
        return new ResponseEntity<>(tournamentService.removeMemberFromTournament(memberId, tournamentId), HttpStatus.OK);
    }

    @PutMapping(path = "api/tournament/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tournament> editTournamentDetails(@RequestBody Tournament tournamentToEdit){
        return new ResponseEntity<>(tournamentService.editTournament(tournamentToEdit), HttpStatus.OK);
    }

    @DeleteMapping(path = "api/tournament/{id}/delete")
    public void deleteTournament(@PathVariable("id") Long tournamentId){
        tournamentService.deleteTournament(tournamentId);
    }
}
