package kr.readvice.api.soccer.services;

import kr.readvice.api.soccer.domains.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    List<Team> findAll();

    List<Team> findAll(Sort sort);

    Page<Team> findAll(Pageable pageable);

    long count();

    String delete(Team team);

    String save(Team team);

    Optional<Team> findById(String teamId);

    boolean existsById(String teamId);

}
