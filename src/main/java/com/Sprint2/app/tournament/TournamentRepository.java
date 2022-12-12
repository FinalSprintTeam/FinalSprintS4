package com.Sprint2.app.tournament;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long>  {
//    String hql = "SELECT u.firstName,u.username,u.status,u.lastName,u.phone,u.team  " +
//            "From  UserInfo u,AppAccess a FETCH ALL PROPERTIES " +
//            "WHERE u.status =? OR u.status =? AND u.team.id = ? AND a.appName = :appName ";

    // String sql = "SELECT t.score FROM TournamentMember t WHERE t.tournament =?";
}

