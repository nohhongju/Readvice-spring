package kr.readvice.api.soccer.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@Entity
@Table(name = "stadiums")
public class Stadium {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stadiumId ;
    private String stadiumName ;
    private String homeTeamId ;
    private String seatCount ;
    private String address ;
    private String ddd ;
    private String tel ;
}
