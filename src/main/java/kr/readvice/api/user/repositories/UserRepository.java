package kr.readvice.api.user.repositories;

import kr.readvice.api.user.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface UserCustomRepository{
    // 000. 사용자의 비밀번호와 이메일를 수정하시오.
    @Modifying
    @Query(value = "")
    String login(User user);
    @Query(value = "")
     void update(User user);
}
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    //null일 수도 아닌 수도 있다.
}
