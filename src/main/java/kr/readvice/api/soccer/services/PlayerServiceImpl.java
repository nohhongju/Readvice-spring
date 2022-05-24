package kr.readvice.api.soccer.services;

import kr.readvice.api.soccer.domains.Player;
import kr.readvice.api.soccer.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository repository;

    @Override
    public List<Player> findAll() {
        return null;
    }

    @Override
    public List<Player> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Player> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public String delete(Player player) {
        return null;
    }

    @Override
    public String save(Player player) {
        return null;
    }

    @Override
    public Optional<Player> findById(String playerId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String playerId) {
        return false;
    }

}
