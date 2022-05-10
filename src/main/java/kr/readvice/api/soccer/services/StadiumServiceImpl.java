package kr.readvice.api.soccer.services;

import kr.readvice.api.soccer.repositories.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StadiumServiceImpl {
    private final StadiumRepository repository;
}
