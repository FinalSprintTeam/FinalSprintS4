package com.Sprint2.app.tournament;

import com.Sprint2.app.person.member.Member;
import com.Sprint2.app.person.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TournamentService {
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    MemberRepository memberRepository;

    public List<Tournament> getTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament getTournamentById(Long tournamentid) {
        return tournamentRepository.findById(tournamentid)
                .orElseThrow(() -> new IllegalStateException("Tournament with id " + tournamentid + " does not exist!"));
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Transactional
    public void addMemberToTournament(Long memberId, Long tournamentId, int score){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("Member with id " + memberId + " does not exist!"));

        Tournament tournament = getTournamentById(tournamentId);

        tournament.addMember(member, score);
    }

    @Transactional
    public void editTournament(Tournament tournament){
        Tournament tournamentToEdit = getTournamentById(tournament.getId());
        tournamentToEdit.setName(tournament.getName());
        tournamentToEdit.setLocation(tournament.getLocation());

        tournamentToEdit.setEntryFee(tournament.getEntryFee());

        tournamentToEdit.setStartDate(tournament.getStartDate());
        tournamentToEdit.setEndDate(tournament.getEndDate());

        // tournamentToEdit.setMembers(tournament.getMembers());
    }

    public void deleteTournament(Long tournamentId){
        boolean exists = tournamentRepository.existsById(tournamentId);
        if (!exists) throw new IllegalStateException("Error! Tournament with ID " + tournamentId + " does not exist!");
        else tournamentRepository.deleteById(tournamentId);
    }
}
