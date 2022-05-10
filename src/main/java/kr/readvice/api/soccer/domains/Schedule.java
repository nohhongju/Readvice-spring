package kr.readvice.api.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stadiumId;
    private String scheDate;
    private String gubun;
    private String homeTeamId;
    private String awayTeamId;
    private String homeScore;
    private String awayScore;
}
