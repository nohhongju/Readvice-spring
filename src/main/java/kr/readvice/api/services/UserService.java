package kr.readvice.api.services;

import kr.readvice.api.domains.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String login(User user);

    List<User> findAll();

    List<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);

    long count();

    String put(User user);

    String delete(User user);

    String save(User user);

    Optional<User> findById(String userid);

    boolean existsById(String userid);
}
