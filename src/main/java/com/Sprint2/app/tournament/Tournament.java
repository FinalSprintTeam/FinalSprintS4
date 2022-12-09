package com.Sprint2.app.tournament;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tournament")
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_sequence")

    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "location")
    private String location;
    @Column(name = "entry_fee")
    private double entryFee;

    //    public void setStartDate(String date) {
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//        Date startDate = null;
//        try {
//            startDate = df.parse(date);
//            this.startDate = startDate;
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }

}

