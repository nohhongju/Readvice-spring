package kr.readvice.api.soccer.services;

import kr.readvice.api.soccer.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl {
    private final TeamRepository repository;
}
