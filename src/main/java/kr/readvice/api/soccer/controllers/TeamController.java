package kr.readvice.api.soccer.controllers;

import kr.readvice.api.soccer.domains.Team;
import kr.readvice.api.soccer.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService service;

    @GetMapping("/findAll")
    public List<Team> findAll() {
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<Team> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<Team> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Team team) {
        return service.delete(team);
    }

    @PostMapping("/join")
    public String save(@RequestBody Team team) {
        return service.save(team);
    }

    @GetMapping("/findById/{stadiumId}")
    public Optional<Team> findById(@PathVariable String teamId) {
        return service.findById(teamId);
    }

    @GetMapping("/existsById/{stadiumId}")
    public boolean existsById(@PathVariable String teamId) {
        return service.existsById(teamId);
    }


}
