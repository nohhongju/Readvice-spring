package kr.readvice.api.soccer.services;

import kr.readvice.api.soccer.repositories.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl {
    private final ScheduleRepository repository;
}
