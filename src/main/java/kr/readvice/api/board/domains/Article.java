package kr.readvice.api.board.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(name="articles")
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projects;
    private String startDate;
    private String status;
    private String team;
    private String progress;
    private String action;

}
