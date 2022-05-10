package kr.readvice.api.auth.repositories;

import kr.readvice.api.auth.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    String login(User user);

    void put(User user);
}
